package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.block.BlockRobotGenerator;
import fr.pacito2.robot.block.blockentity.BlockEntityRobotGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ListBlock {
    public static final Map<Identifier, Block> BLOCKS = new HashMap<>();
    public static final Map<Identifier, BlockEntity> BLOCKS_ENTITY = new HashMap<>();

    public static final Block BLOCK_ROBOT_GENERATOR = add("robot_generator_block", new BlockRobotGenerator("robot_generator_block"));

    public static BlockEntityType<BlockEntityRobotGenerator> BLOCK_ENTITY_ROBOT_GENERATOR = Registry.register(Registry.BLOCK_ENTITY_TYPE, "robot:robot_generator_block_entity", FabricBlockEntityTypeBuilder.create(BlockEntityRobotGenerator::new, BLOCK_ROBOT_GENERATOR).build(null));;

    private static <block extends Block> block add(String name, block block) {
        BLOCKS.put(new Identifier(RobotMod.MOD_ID, name), block);
        return block;
    }
}
