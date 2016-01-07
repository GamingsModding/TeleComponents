package com.gamingsmod.telecomponents.common.override;

import com.gamingsmod.telecomponents.common.init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.BlockObsidian;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;

import java.util.Random;

public class BlockOverride
{
    @SubscribeEvent
    public void on(BlockEvent.HarvestDropsEvent e) {
        if (e.block instanceof BlockObsidian) {
            e.drops.clear();
            Random rand = new Random();
            ItemStack stack = new ItemStack(ModItems.obsidianChunk, rand.nextInt(4) + 1);
            e.drops.add(stack);
        }
    }
}
