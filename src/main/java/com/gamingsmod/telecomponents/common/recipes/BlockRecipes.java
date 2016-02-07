package com.gamingsmod.telecomponents.common.recipes;

import com.gamingsmod.telecomponents.common.init.ModBlocks;
import com.gamingsmod.telecomponents.common.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockRecipes
{
    public static void init() {
        addBlockRecipe(new ItemStack(ModBlocks.teleIngotBlock), new ItemStack(ModItems.teleIngot));
        addBlockRecipe(new ItemStack(ModBlocks.compressedEndStone), new ItemStack(Blocks.end_stone));
        addBlockRecipe(new ItemStack(Blocks.obsidian), new ItemStack(ModItems.obsidianChunk));
    }

    private static void addBlockRecipe(ItemStack create, ItemStack resource) {
        GameRegistry.addShapedRecipe(create, "###", "###", "###", '#', resource);
    }
}
