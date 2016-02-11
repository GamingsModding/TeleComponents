package com.gamingsmod.telecomponents.common.override;

import com.gamingsmod.telecomponents.common.init.ModItems;
import net.minecraft.block.BlockObsidian;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class BlockOverride
{
    @SubscribeEvent
    public void onDrops(BlockEvent.HarvestDropsEvent e)
    {
        if (e.state.getBlock() instanceof BlockObsidian) {
            if (!e.isSilkTouching) {
                e.drops.clear();
                Random rand = new Random();
                ItemStack stack = new ItemStack(ModItems.obsidianChunk, (rand.nextInt(4) + 1)*(e.fortuneLevel + 1));
                e.drops.add(stack);
            }
        }
    }

}
