package fr.pacito2.robot.block.blockentity;

import fr.pacito2.robot.util.ListBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockEntityRobotGenerator extends BlockEntity {
    private int robot = 5;

    public BlockEntityRobotGenerator(BlockPos pos, BlockState state) {
        super(ListBlock.BLOCK_ENTITY_ROBOT_GENERATOR, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        nbt.putInt("robot", this.robot);

        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        this.robot = nbt.getInt("robot");
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

    }

    public int getRobot() {
        return robot;
    }
}