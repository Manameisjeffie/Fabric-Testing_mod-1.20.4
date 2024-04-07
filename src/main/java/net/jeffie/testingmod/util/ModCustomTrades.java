package net.jeffie.testingmod.util;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.jeffie.testingmod.item.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades
{
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            new ItemStack(ModItems.PLAT_INGOT, 4),
                            new ItemStack(ModItems.ORE_DETECTOR, 1),
                            8, 5, 0.05f));
                });
    }
}
