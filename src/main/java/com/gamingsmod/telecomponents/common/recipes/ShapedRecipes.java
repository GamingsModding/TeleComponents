package com.gamingsmod.telecomponents.common.recipes;

import com.gamingsmod.telecomponents.common.init.ModArmor;
import com.gamingsmod.telecomponents.common.init.ModBlocks;
import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.init.ModTools;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ShapedRecipes
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ModItems.teleIngot), "ede", "dgd", "ede",
                'e', new ItemStack(Items.ender_eye),
                'd', new ItemStack(Items.diamond),
                'g', new ItemStack(Items.gold_ingot));
        GameRegistry.addRecipe(new ItemStack(ModBlocks.teleIngotBlock), "###", "###", "###", '#', new ItemStack(ModItems.teleIngot));
        GameRegistry.addRecipe(new ItemStack(ModTools.toolTelePickaxe), "###", " s ", " s ",
                '#', new ItemStack(ModItems.teleIngot),
                's', new ItemStack(ModItems.enderStick));
        GameRegistry.addRecipe(new ItemStack(ModTools.toolTeleSword), "i", "i", "s",
                'i', new ItemStack(ModItems.teleIngot),
                's', new ItemStack(ModItems.enderStick));
        GameRegistry.addRecipe(new ItemStack(ModTools.toolTeleAxe), "ii ", "is ", " s ",
                'i', new ItemStack(ModItems.teleIngot),
                's', new ItemStack(ModItems.enderStick));
        GameRegistry.addRecipe(new ItemStack(ModTools.toolTeleSpade), "i", "s", "s",
                'i', new ItemStack(ModItems.teleIngot),
                's', new ItemStack(ModItems.enderStick));
        GameRegistry.addRecipe(new ItemStack(ModTools.toolTeleHoe), "ii ", " s ", " s ",
                'i', new ItemStack(ModItems.teleIngot),
                's', new ItemStack(ModItems.enderStick));

        GameRegistry.addRecipe(new ItemStack(ModBlocks.compressedEndStone), "###", "###", "###", '#', new ItemStack(Blocks.end_stone));
        GameRegistry.addRecipe(new ItemStack(ModItems.enderStick), "#  ", "#  ", '#', new ItemStack(Items.ender_pearl));
        GameRegistry.addRecipe(new ItemStack(ModItems.epCreationCore), "###", "#a#", "###",
                '#', new ItemStack(Items.ender_pearl),
                'a', new ItemStack(ModBlocks.compressedEndStone));
        GameRegistry.addRecipe(new ItemStack(ModItems.enderPearlGun), " i ", "ici", " is",
                'i', new ItemStack(ModItems.teleIngot),
                'c', new ItemStack(ModItems.epCreationCore),
                's', new ItemStack(ModItems.enderStick));

        GameRegistry.addRecipe(new ItemStack(ModArmor.teleIngotBoots), "i i", "i i", 'i', new ItemStack(ModItems.teleIngot));
        GameRegistry.addRecipe(new ItemStack(ModArmor.teleIngotHelmet), "iii", "i i", 'i', new ItemStack(ModItems.teleIngot));
        GameRegistry.addRecipe(new ItemStack(ModArmor.teleIngotChest), "i i", "iii", "iii", 'i', new ItemStack(ModItems.teleIngot));
        GameRegistry.addRecipe(new ItemStack(ModArmor.teleIngotLegs), "iii", "i i", "i i", 'i', new ItemStack(ModItems.teleIngot));
    }
}
