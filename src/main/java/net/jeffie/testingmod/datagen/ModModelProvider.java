package net.jeffie.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jeffie.testingmod.block.ModBlocks;
import net.jeffie.testingmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLAT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PLAT_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLAT_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PLAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.HAPPY_FACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAD_FACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORE_DETECTOR, Models.HANDHELD);

        itemModelGenerator.register(ModItems.PLAT_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLAT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLAT_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLAT_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.PLAT_HOE, Models.HANDHELD);
    }
}
