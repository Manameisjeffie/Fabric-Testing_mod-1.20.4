package net.jeffie.testingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jeffie.testingmod.TestingMod;
import net.jeffie.testingmod.item.custom.OreDetectorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item HAPPY_FACE = registerItem("happy_face", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SAD_FACE = registerItem("sad_face", new Item(new FabricItemSettings().maxCount(1)));

    public static final Item PLAT_INGOT = registerItem("plat_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_PLAT = registerItem("raw_plat", new Item(new FabricItemSettings()));
    public static final Item ORE_DETECTOR = registerItem("ore_detector", new OreDetectorItem(new FabricItemSettings(), 3));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        TestingMod.LOGGER.info("Registering Mod Items for " + TestingMod.MOD_ID);
    }
}
