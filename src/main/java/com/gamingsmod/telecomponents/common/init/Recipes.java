package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.recipes.BlockRecipes;
import com.gamingsmod.telecomponents.common.recipes.ShapedRecipes;
import com.gamingsmod.telecomponents.common.recipes.ShapelessRecipes;
import com.gamingsmod.telecomponents.common.utility.LogHelper;

public final class Recipes
{
    public static void init()
    {
        ShapelessRecipes.init();
        ShapedRecipes.init();
        BlockRecipes.init();

        LogHelper.info("Loaded Recipes");
    }
}
