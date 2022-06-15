package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.block.blockentity.BlockEntityRobotGenerator;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ListBlockEntity {
    public static final Map<Identifier, BlockEntityType<BlockEntityRobotGenerator>> BLOCKS_ENTITY = new HashMap<>();

    public static BlockEntityType<BlockEntityRobotGenerator> BLOCK_ENTITY_ROBOT_GENERATOR = add("robot_generator_block_entity", FabricBlockEntityTypeBuilder.create(BlockEntityRobotGenerator::new, ListBlock.BLOCK_ROBOT_GENERATOR).build(null));

    private static <blockEntity extends BlockEntityType<BlockEntityRobotGenerator>> blockEntity add(String name, blockEntity blockEntity) {
        BLOCKS_ENTITY.put(new Identifier(RobotMod.MOD_ID, name), blockEntity);
        return blockEntity;
    }
}
