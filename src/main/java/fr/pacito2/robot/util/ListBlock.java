package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.block.BlockRobotGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ListBlock {
    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();

    public static final Block BLOCK_ROBOT_GENERATOR = add("robot_generator_block", new BlockRobotGenerator("robot_generator_block"));

    private static <block extends Block> block add(String name, block block) {
        BLOCKS.put(new Identifier(RobotMod.MOD_ID, name), block);
        return block;
    }
}
