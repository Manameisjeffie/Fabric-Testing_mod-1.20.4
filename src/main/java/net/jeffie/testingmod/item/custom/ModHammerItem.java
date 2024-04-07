package net.jeffie.testingmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModHammerItem extends MiningToolItem {
    final int range;
    BlockHitResult blockHit;

    public ModHammerItem(float attackDamage, float attackSpeed, ToolMaterial material, TagKey<Block> effectiveBlocks, Settings settings, int range) {
        super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
        this.range = range;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (selected)
        {
            MinecraftClient client = MinecraftClient.getInstance();
            HitResult hit = client.crosshairTarget;

            if (!world.isClient()) {
                if (hit != null && hit.getType() == HitResult.Type.BLOCK)
                {
                    blockHit = (BlockHitResult) hit;
                    //entity.sendMessage(Text.literal(blockHit.getSide().getName()));
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context)
    {
        if (Screen.hasShiftDown())
            tooltip.add(Text.literal("It Mines in a " + range+"x"+range+"x"+"1" + " area around the mined block (the block is in it's center)").withColor(Colors.RED));
        else
        {
            tooltip.add(Text.literal("Press Shift For More Info").withColor(Colors.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient())
        {
            if (this.isSuitableFor(state))
            {
                switch (blockHit.getSide().getName())
                {
                    case "up", "down":
                        Mine(new BlockPos(pos.getX(), pos.getZ(), pos.getY()), world);
                        break;
                    case "north", "south":
                        Mine(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), world);
                        break;
                    case "east", "west":
                        Mine(new BlockPos(pos.getY(), pos.getZ(), pos.getX()), world);
                        break;
                    default:
                        break;
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }

    public void Mine(BlockPos minePos, World world)
    {
        BlockPos curPos;
        String bSide = blockHit.getSide().getName();
        for (int i = minePos.getX()-((range-1)/2); i <= minePos.getX()+((range-1)/2); i++)
        {
            for (int j = minePos.getY()-((range-1)/2); j <= minePos.getY()+((range-1)/2); j++)
            {
                switch (bSide)
                {
                    case "up", "down":
                        curPos = new BlockPos(i, minePos.getZ(), j);
                        if (!world.getBlockState(curPos).getBlock().equals(Blocks.AIR) && this.isSuitableFor(world.getBlockState(curPos)))
                        {
                            world.breakBlock(curPos, true);
                        }
                        break;
                    case "north", "south":
                        curPos = new BlockPos(i, j, minePos.getZ());
                        if (!world.getBlockState(curPos).getBlock().equals(Blocks.AIR) && this.isSuitableFor(world.getBlockState(curPos)))
                        {
                            world.breakBlock(curPos, true);
                        }
                        break;
                    case "east", "west":
                        curPos = new BlockPos(minePos.getZ(), i, j);
                        if (!world.getBlockState(curPos).getBlock().equals(Blocks.AIR) && this.isSuitableFor(world.getBlockState(curPos)))
                        {
                            world.breakBlock(curPos, true);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
