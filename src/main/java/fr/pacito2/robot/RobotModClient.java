package fr.pacito2.robot;

import fr.pacito2.robot.handler.RegistryHandler;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class RobotModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegistryHandler.registerRenderersAndModels();
        RegistryHandler.registerScreens();
    }
}