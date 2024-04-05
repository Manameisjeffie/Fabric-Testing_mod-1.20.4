package net.jeffie.testingmod.item.custom;

import net.jeffie.testingmod.block.ModBlocks;
import net.jeffie.testingmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class OreDetectorItem extends Item {

    private final int oreDetectR;

    public OreDetectorItem(Settings settings, int oreDetectionRange)
    {
        super(settings);
        this.oreDetectR = oreDetectionRange;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if (!world.isClient())
        {
            Vec3d playerPos = user.getPos();
            BlockPos bPos;
            for (int i = (int)playerPos.getX()-oreDetectR; i < playerPos.getX() + oreDetectR; i++)
            {
                for (int j = (int)playerPos.getY()-oreDetectR; j < playerPos.getY() + oreDetectR; j++)
                {
                    for (int k = (int)playerPos.getZ()-oreDetectR; k < playerPos.getZ() + oreDetectR; k++)
                    {
                        bPos = new BlockPos(i, j, k);
                        BlockState blockState = world.getBlockState(bPos);
                        if (isOre(blockState))
                        {
                            user.sendMessage(Text.literal(blockState.getBlock().asItem().getName().getString() + " has been found in §lX: " + bPos.getX() + " Y: " + bPos.getY() + " Z: " + bPos.getZ()).withColor(chooseColor(blockState)), false);
                            user.getStackInHand(hand).damage(1, user, playerEntity -> playerEntity.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown())
            tooltip.add(Text.literal("It Detects Ore's in a " + oreDetectR+"x"+oreDetectR+"x"+oreDetectR + " range around the player (the player is in it's center)").withColor(Colors.RED));
        else
        {
            tooltip.add(Text.literal("Press Shift For More Info").withColor(Colors.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    private boolean isOre(BlockState state)
    {
        return state.isIn(ModTags.Blocks.ORE_DETECTOR_DETECTABLE_BLOCKS);
    }

    private int chooseColor(BlockState state)
    {
        Block block = state.getBlock();
        return switch (Registries.BLOCK.getId(block).getPath()) {
            case "diamond_ore", "deepslate_diamond_ore" -> MapColor.DIAMOND_BLUE.color;
            case "gold_ore", "deepslate_gold_ore" -> MapColor.GOLD.color;
            case "iron_ore", "deepslate_iron_ore" -> MapColor.IRON_GRAY.color;
            case "emerald_ore", "deepslate_emerald_ore" -> MapColor.EMERALD_GREEN.color;
            default -> Colors.WHITE;
        };
    }
}
