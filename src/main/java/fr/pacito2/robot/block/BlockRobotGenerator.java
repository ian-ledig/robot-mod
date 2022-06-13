package fr.pacito2.robot.block;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.util.ListItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class BlockRobotGenerator extends HorizontalFacingBlock
{
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
}