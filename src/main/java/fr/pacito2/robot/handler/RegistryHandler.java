package fr.pacito2.robot.handler;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.entity.EntityRobot;
import fr.pacito2.robot.entity.client.model.EntityModelRobot;
import fr.pacito2.robot.entity.client.renderer.EntityRendererRobot;
import fr.pacito2.robot.util.ListBlock;
import fr.pacito2.robot.util.ListBlockEntity;
import fr.pacito2.robot.util.ListEntity;
import fr.pacito2.robot.util.ListItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistryHandler {
    private static final Logger LOGGER = LogManager.getLogger(RobotMod.MOD_ID);

    public static void registerBlocks()
    {
        // Blocks
        for (Identifier id : ListBlock.BLOCKS.keySet())
        {
            Registry.register(Registry.BLOCK, id, ListBlock.BLOCKS.get(id));
        }

        // Blocks entities
        for (Identifier id : ListBlockEntity.BLOCKS_ENTITY.keySet())
        {
            Registry.register(Registry.BLOCK_ENTITY_TYPE, id, ListBlockEntity.BLOCKS_ENTITY.get(id));
        }

        LOGGER.info(RobotMod.MOD_ID + " blocks registered");
    }

    public static void registerItems()
    {
        for (Identifier id : ListItem.ITEMS.keySet())
        {
            Registry.register(Registry.ITEM, id, ListItem.ITEMS.get(id));
        }
        LOGGER.info(RobotMod.MOD_ID + " items registered");
    }

    public static void registerEntities()
    {
        // Robot
        FabricDefaultAttributeRegistry.register(ListEntity.ROBOT, EntityRobot.createMobAttributes()
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.2)
        );

        LOGGER.info(RobotMod.MOD_ID + " entities registered");
    }

    @Environment(EnvType.CLIENT)
    public static void registerRenderersAndModels(){
        EntityRendererRegistry.register(ListEntity.ROBOT, EntityRendererRobot::new);
        //EntityModelLayerRegistry.registerModelLayer(ListEntity.MODEL_LAYER_ROBOT, EntityModelRobot::getTexturedModelData);

        LOGGER.info(RobotMod.MOD_ID + " entities renders and models registered");
    }
}
