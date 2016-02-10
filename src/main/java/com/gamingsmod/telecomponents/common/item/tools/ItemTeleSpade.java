package com.gamingsmod.telecomponents.common.item.tools;

import com.gamingsmod.telecomponents.common.reference.Material;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.Set;

public class ItemTeleSpade extends ItemToolTeleC
{

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.clay, Blocks.dirt, Blocks.farmland, Blocks.grass, Blocks.gravel, Blocks.mycelium, Blocks.sand, Blocks.snow, Blocks.snow_layer, Blocks.soul_sand});

    public ItemTeleSpade() {
        super("teleIngotSpace", 1.0F, Material.Tools.TELEINGOT, EFFECTIVE_ON);
    }

    // From ItemSpade
    public boolean canHarvestBlock(Block blockIn)
    {
        return blockIn == Blocks.snow_layer ? true : blockIn == Blocks.snow;
    }
}