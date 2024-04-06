package net.jeffie.testingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jeffie.testingmod.TestingMod;
import net.jeffie.testingmod.item.custom.ModArmorItem;
import net.jeffie.testingmod.item.custom.OreDetectorItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems
{
    public static final Item HAPPY_FACE = registerItem("happy_face", new Item(new FabricItemSettings().maxCount(1)));
    public static final Item SAD_FACE = registerItem("sad_face", new Item(new FabricItemSettings().maxCount(1)));

    public static final Item PLAT_INGOT = registerItem("plat_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_PLAT = registerItem("raw_plat", new Item(new FabricItemSettings()));
    public static final Item ORE_DETECTOR = registerItem("ore_detector", new OreDetectorItem(new FabricItemSettings().maxCount(1).maxDamage(64), 3));
    public static final Item PLAT_PICKAXE = registerItem("plat_pickaxe", new PickaxeItem(ModToolMaterial.PLAT, 4, -3f, new FabricItemSettings()));
    public static final Item PLAT_SWORD = registerItem("plat_sword", new SwordItem(ModToolMaterial.PLAT, 8, -2f, new FabricItemSettings()));
    public static final Item PLAT_AXE = registerItem("plat_axe", new AxeItem(ModToolMaterial.PLAT, 10, -2.4f, new FabricItemSettings()));
    public static final Item PLAT_SHOVEL = registerItem("plat_shovel", new ShovelItem(ModToolMaterial.PLAT, 3, -3f, new FabricItemSettings()));
    public static final Item PLAT_HOE = registerItem("plat_hoe", new HoeItem(ModToolMaterial.PLAT, 2, 0.00f, new FabricItemSettings()));

    public static final ArmorItem PLAT_HELMET = registerArmorItem("plat_helmet", new ModArmorItem(ModArmorMaterials.PLAT, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final ArmorItem PLAT_CHESTPLATE = registerArmorItem("plat_chestplate", new ArmorItem(ModArmorMaterials.PLAT, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final ArmorItem PLAT_LEGGINGS = registerArmorItem("plat_leggings", new ArmorItem(ModArmorMaterials.PLAT, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final ArmorItem PLAT_BOOTS = registerArmorItem("plat_boots", new ArmorItem(ModArmorMaterials.PLAT, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }

    private static ArmorItem registerArmorItem(String name, ArmorItem item)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        TestingMod.LOGGER.info("Registering Mod Items for " + TestingMod.MOD_ID);
    }
}
