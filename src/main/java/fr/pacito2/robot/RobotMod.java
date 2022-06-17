package fr.pacito2.robot;

import fr.pacito2.robot.handler.RegistryHandler;
import fr.pacito2.robot.screen.ScreenHandlerRobot;
import fr.pacito2.robot.util.ListBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class RobotMod implements ModInitializer {
    public static final String MOD_ID = "robot";

    public static ItemGroup ITEMGROUP = FabricItemGroupBuilder.build(
            new Identifier("robot", "item_group"),
            () -> new ItemStack(Item.BLOCK_ITEMS.get(ListBlock.BLOCK_ROBOT_GENERATOR)));

    @Override
    public void onInitialize() {
        RegistryHandler.registerBlocks();
        RegistryHandler.registerItems();
        RegistryHandler.registerEntities();
    }
}
