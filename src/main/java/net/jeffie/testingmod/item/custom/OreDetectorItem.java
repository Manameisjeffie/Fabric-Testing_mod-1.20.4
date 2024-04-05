package net.jeffie.testingmod.item.custom;

import net.jeffie.testingmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MinecartItem;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.ColorResolver;

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
                            user.sendMessage(Text.literal(blockState.getBlock().asItem().getName().getString() + " has been found in X: " + bPos.getX() + " Y: " + bPos.getY() + " Z: " + bPos.getZ()).withColor(blockState.getMapColor(world.getChunk(bPos), bPos).color), false);
                        }
                    }
                }
            }
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }

    private boolean isOre(BlockState state)
    {
        return state.isOf(Blocks.DIAMOND_ORE) || state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(ModBlocks.PLAT_ORE) || state.isOf(Blocks.DEEPSLATE_DIAMOND_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.EMERALD_ORE) || state.isOf(Blocks.DEEPSLATE_EMERALD_ORE);
    }
}
