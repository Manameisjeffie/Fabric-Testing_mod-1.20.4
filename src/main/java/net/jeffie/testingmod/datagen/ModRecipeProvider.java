package net.jeffie.testingmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jeffie.testingmod.block.ModBlocks;
import net.jeffie.testingmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLAT_PICKAXE)
                .pattern("PPP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_PICKAXE, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLAT_AXE)
                .pattern("PP ")
                .pattern("PS ")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_AXE, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLAT_SHOVEL)
                .pattern(" P ")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_SHOVEL, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLAT_HOE)
                .pattern(" PP")
                .pattern(" S ")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_HOE, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PLAT_HAMMER)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_HAMMER, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLAT_SWORD)
                .pattern(" P ")
                .pattern(" P ")
                .pattern(" S ")
                .input('P', ModItems.PLAT_INGOT)
                .input('S', Items.STICK)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_SWORD, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLAT_HELMET)
                .pattern("PPP")
                .pattern("P P")
                .pattern("   ")
                .input('P', ModItems.PLAT_INGOT)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_HELMET, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLAT_CHESTPLATE)
                .pattern("P P")
                .pattern("PPP")
                .pattern("PPP")
                .input('P', ModItems.PLAT_INGOT)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_CHESTPLATE, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLAT_LEGGINGS)
                .pattern("PPP")
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PLAT_INGOT)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_LEGGINGS, ModItems.PLAT_INGOT));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PLAT_BOOTS)
                .pattern("   ")
                .pattern("P P")
                .pattern("P P")
                .input('P', ModItems.PLAT_INGOT)
                .group("platinium")
                .criterion(RecipeProvider.hasItem(ModItems.PLAT_INGOT), RecipeProvider.conditionsFromItem(ModItems.PLAT_INGOT))
                .offerTo(exporter, RecipeProvider.convertBetween(ModItems.PLAT_BOOTS, ModItems.PLAT_INGOT));

    }
}
