package com.gamingsmod.telecomponents.recipes;

import com.gamingsmod.telecomponents.init.ModBlocks;
import com.gamingsmod.telecomponents.init.ModItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ShapelessRecipes
{
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.teleIngot, 9), new ItemStack(ModBlocks.teleIngotBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.end_stone, 9), new ItemStack(ModBlocks.compressedEndStone));
    }
}
