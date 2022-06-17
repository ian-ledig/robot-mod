package fr.pacito2.robot.block.blockentity;

import fr.pacito2.robot.block.inventory.ImplementedInventory;
import fr.pacito2.robot.screen.ScreenHandlerRobot;
import fr.pacito2.robot.util.ListBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockEntityRobotGenerator extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(8, ItemStack.EMPTY);
    private int robot = 5;

    public BlockEntityRobotGenerator(BlockPos pos, BlockState state) {
        super(ListBlockEntity.BLOCK_ENTITY_ROBOT_GENERATOR, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("robot", this.robot);
        Inventories.writeNbt(nbt, inventory);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.robot = nbt.getInt("robot");
        Inventories.readNbt(nbt, inventory);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public static void tick(World world, BlockPos pos, BlockState state, BlockEntityRobotGenerator be) {
        if(hasRecipe(be) && hasNotReachedStackLimit(be)) {
            // DO SOMETHING
        }
    }

    private static boolean hasRecipe(BlockEntityRobotGenerator entity) {
        return entity.getStack(0).getItem() == Items.COAL;
    }

    private static boolean hasNotReachedStackLimit(BlockEntityRobotGenerator entity) {
        return entity.getStack(8).getCount() < entity.getStack(8).getMaxCount();
    }

    public int getRobot() {
        return robot;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Robot");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
        return new ScreenHandlerRobot(syncId, inv, this);
    }
}