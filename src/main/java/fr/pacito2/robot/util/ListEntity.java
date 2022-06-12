package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.entity.EntityRobot;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;

public class ListEntity {

    public static final EntityType<EntityRobot> ROBOT = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("robot", "robot"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EntityRobot::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityModelLayer MODEL_LAYER_ROBOT = new EntityModelLayer(new Identifier(RobotMod.MOD_ID, "robot"), "main");
}
