package fr.pacito2.robot.entity.client.model;

import com.google.common.collect.ImmutableList;
import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.entity.EntityRobot;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EntityModelRobot extends AnimatedGeoModel<EntityRobot>{
    @Override
    public Identifier getModelResource(EntityRobot object) {
        return new Identifier(RobotMod.MOD_ID, "geo/robot.geo.json");
    }

    @Override
    public Identifier getTextureResource(EntityRobot object) {
        return new Identifier(RobotMod.MOD_ID, "textures/entity/robot/robot.png");
    }

    @Override
    public Identifier getAnimationResource(EntityRobot animatable) {
        return new Identifier(RobotMod.MOD_ID, "animations/robot.animation.json");
    }
}
