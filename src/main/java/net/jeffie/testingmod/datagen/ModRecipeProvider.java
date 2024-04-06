package net.jeffie.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jeffie.testingmod.block.ModBlocks;
import net.jeffie.testingmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> PLAT_SMELTABLES = List.of(ModBlocks.PLAT_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, PLAT_SMELTABLES, RecipeCategory.MISC, ModItems.PLAT_INGOT, 0.7f, 200, "platinium");
        offerBlasting(exporter, PLAT_SMELTABLES, RecipeCategory.MISC, ModItems.PLAT_INGOT, 0.7f, 100, "platinium");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PLAT_INGOT, RecipeCategory.DECORATIONS, ModBlocks.PLAT_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SAD_FACE, 1)
                .input(ModItems.HAPPY_FACE)
                .input(Items.STICK)
                .group("faces")
                .criterion(RecipeProvider.hasItem(ModItems.HAPPY_FACE), RecipeProvider.conditionsFromItem(ModItems.HAPPY_FACE))
                .criterion(RecipeProvider.hasItem(Items.STICK), RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.SAD_FACE, ModItems.HAPPY_FACE));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HAPPY_FACE, 1)
                .input(ModItems.SAD_FACE)
                .input(Items.GOLD_INGOT)
                .group("faces")
                .criterion(RecipeProvider.hasItem(ModItems.SAD_FACE), RecipeProvider.conditionsFromItem(ModItems.SAD_FACE))
                .criterion(RecipeProvider.hasItem(Items.GOLD_INGOT), RecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.HAPPY_FACE, ModItems.SAD_FACE));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLAT_INGOT, 1)
                .input(ModItems.RAW_PLAT, 4)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.RAW_PLAT), RecipeProvider.conditionsFromItem(ModItems.RAW_PLAT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_INGOT, ModItems.RAW_PLAT));
    }
}
