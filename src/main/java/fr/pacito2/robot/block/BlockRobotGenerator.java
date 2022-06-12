package fr.pacito2.robot.block;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.util.ListItem;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class BlockRobotGenerator extends Block
{
    public BlockRobotGenerator(String name)
    {
        super(FabricBlockSettings.of(Material.STONE)
                .requiresTool()
                .strength(3.5f, 6f)
                .sounds(BlockSoundGroup.METAL));

        new Identifier(RobotMod.MOD_ID, name);

        ListItem.add(name, new BlockItem(this, new Item.Settings().group(RobotMod.ITEMGROUP)));
    }
}