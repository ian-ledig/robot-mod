package fr.pacito2.robot.entity.renderer;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.entity.EntityRobot;
import fr.pacito2.robot.entity.model.EntityModelRobot;
import fr.pacito2.robot.util.ListEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class EntityRendererRobot extends MobEntityRenderer<EntityRobot, EntityModelRobot> {

    public EntityRendererRobot(EntityRendererFactory.Context context) {
        super(context, new EntityModelRobot(context.getPart(ListEntity.MODEL_LAYER_ROBOT)), 0.5f);
    }

    @Override
    public Identifier getTexture(EntityRobot entity) {
        return new Identifier(RobotMod.MOD_ID, "textures/entity/robot/robot.png");
    }
}