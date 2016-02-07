package com.gamingsmod.telecomponents.common.override;

import com.gamingsmod.telecomponents.common.init.ModItems;
import net.minecraft.block.BlockObsidian;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

public class BlockOverride
{
    @SubscribeEvent
    public void onDrops(BlockEvent.HarvestDropsEvent event)
    {
        if (event.drops == Blocks.obsidian) {
            event.drops.clear();
            event.drops.add(new ItemStack(ModItems.obsidianChunk));
        }
    }

}
