package com.gamingsmod.telecomponents.common.item.tools;

import com.gamingsmod.telecomponents.common.reference.Material;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Set;

public class ItemTeleAxe extends ItemToolTeleC
{

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder});

    public ItemTeleAxe()
    {
        super("teleIngotAxe", 3.0F, Material.Tools.TELEINGOT, EFFECTIVE_ON);
    }

    //From ItemAxe
    public float getStrVsBlock(ItemStack stack, Block block)
    {
        return block.getMaterial() != net.minecraft.block.material.Material.wood && block.getMaterial() != net.minecraft.block.material.Material.plants && block.getMaterial() != net.minecraft.block.material.Material.vine ? super.getStrVsBlock(stack, block) : this.efficiencyOnProperMaterial;
    }
}
