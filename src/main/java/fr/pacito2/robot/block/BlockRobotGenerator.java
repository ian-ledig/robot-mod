package fr.pacito2.robot.block;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.block.blockentity.BlockEntityRobotGenerator;
import fr.pacito2.robot.util.ListBlock;
import fr.pacito2.robot.util.ListItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BlockRobotGenerator extends HorizontalFacingBlockWithEntity implements BlockEntityProvider
{
    private BlockEntityRobotGenerator blockEntity;

    public BlockRobotGenerator(String name)
    {
        super(FabricBlockSettings.of(Material.STONE)
                .requiresTool()
                .strength(3.5f, 6f)
                .sounds(BlockSoundGroup.METAL));

        new Identifier(RobotMod.MOD_ID, name);

        setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(Properties.FACING, Direction.NORTH)).with(Properties.LIT, false));

        ListItem.add(name, new BlockItem(this, new Item.Settings().group(RobotMod.ITEMGROUP)));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        System.out.println("vvv " + blockEntity.getRobot());
        return super.onUse(state, world, pos, player, hand, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(Properties.FACING, Properties.LIT);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        super.getPlacementState(ctx);
        return (BlockState)this.getDefaultState().with(Properties.FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return this.blockEntity = new BlockEntityRobotGenerator(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, ListBlock.BLOCK_ENTITY_ROBOT_GENERATOR, BlockEntityRobotGenerator::tick);
    }
}