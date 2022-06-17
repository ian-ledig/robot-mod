package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import fr.pacito2.robot.screen.ScreenHandlerRobot;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ListScreen {

    public static final ScreenHandlerType<ScreenHandlerRobot> SCREEN_HANDLER_ROBOT = ScreenHandlerRegistry.registerSimple(new Identifier(RobotMod.MOD_ID, "robot"), ScreenHandlerRobot::new);
}
