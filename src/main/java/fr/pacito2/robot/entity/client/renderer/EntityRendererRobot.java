package fr.pacito2.robot.entity.client.renderer;

import fr.pacito2.robot.entity.EntityRobot;
import fr.pacito2.robot.entity.client.model.EntityModelRobot;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class EntityRendererRobot extends GeoEntityRenderer<EntityRobot>{
    public EntityRendererRobot(EntityRendererFactory.Context ctx) {
        super(ctx, new EntityModelRobot());
    }

    @Override
    public Identifier getTextureResource(EntityRobot instance) {
        return super.getTextureResource(instance);
    }
}