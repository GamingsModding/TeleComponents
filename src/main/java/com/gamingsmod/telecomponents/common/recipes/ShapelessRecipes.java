package com.gamingsmod.telecomponents.common.recipes;

import com.gamingsmod.telecomponents.common.init.ModBlocks;
import com.gamingsmod.telecomponents.common.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ShapelessRecipes
{
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.teleIngot, 9), new ItemStack(ModBlocks.teleIngotBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.end_stone, 9), new ItemStack(ModBlocks.compressedEndStone));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.obsidianChunk, 9), new ItemStack(Blocks.obsidian));
    }
}
