package net.jeffie.testingmod.group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.jeffie.testingmod.TestingMod;
import net.jeffie.testingmod.block.ModBlocks;
import net.jeffie.testingmod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups
{
    public static final ItemGroup FACES_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestingMod.MOD_ID, "faces"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.faces"))
                    .icon(() -> new ItemStack(ModItems.HAPPY_FACE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HAPPY_FACE);
                        entries.add(ModItems.SAD_FACE);
                    }).build());
    public static final ItemGroup PLAT_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestingMod.MOD_ID, "platinium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.platinium"))
                    .icon(() -> new ItemStack(ModItems.PLAT_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PLAT_INGOT);
                        entries.add(ModBlocks.PLAT_BLOCK);
                        entries.add(ModBlocks.PLAT_ORE);
                    }).build());

    public static void registerItemGroups()
    {
        TestingMod.LOGGER.info("Registering Creative Tabs in: " + TestingMod.MOD_ID);
    }
}