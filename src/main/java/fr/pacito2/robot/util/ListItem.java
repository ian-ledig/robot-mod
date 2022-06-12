package fr.pacito2.robot.util;

import fr.pacito2.robot.RobotMod;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class ListItem {
    public static final Map<Identifier, BlockItem> ITEMS = new HashMap<>();



    public static <I extends BlockItem> I add(String name, I item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        ITEMS.put(new Identifier(RobotMod.MOD_ID, name), item);
        return item;
    }
}
