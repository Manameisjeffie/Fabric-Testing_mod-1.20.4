package net.jeffie.testingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.jeffie.testingmod.TestingMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks()
    {
        TestingMod.LOGGER.info("Registering Mod Blocks for " + TestingMod.MOD_ID);
    }
}
