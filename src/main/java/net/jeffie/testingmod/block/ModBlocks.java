package net.jeffie.testingmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.jeffie.testingmod.TestingMod;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks
{
    public static final Block PLAT_BLOCK = registerBlock("plat_block",
            new Block(FabricBlockSettings.create()
            .mapColor(MapColor.IRON_GRAY)
            .instrument(Instrument.IRON_XYLOPHONE)
            .requiresTool()
            .strength(7.0f, 8.0f)
            .sounds(BlockSoundGroup.METAL)));
    public static final Block PLAT_ORE = registerBlock("plat_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), FabricBlockSettings.create()
            .mapColor(MapColor.STONE_GRAY)
            .instrument(Instrument.BASEDRUM)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE)
            .strength(3.0f, 3.0f)));

    private static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestingMod.MOD_ID, name), block);
    }


    public static void registerModBlocks()
    {
        TestingMod.LOGGER.info("Registering Mod Blocks for " + TestingMod.MOD_ID);
    }
}
