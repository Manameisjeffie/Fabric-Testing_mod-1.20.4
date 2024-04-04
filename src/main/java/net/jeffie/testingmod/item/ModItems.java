package net.jeffie.testingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jeffie.testingmod.TestingMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item HAPPY_FACE = registerItem("happy_face", new Item(new FabricItemSettings()));
    public static final Item SAD_FACE = registerItem("sad_face", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        TestingMod.LOGGER.info("Registering Mod Items for " + TestingMod.MOD_ID);
    }
}
