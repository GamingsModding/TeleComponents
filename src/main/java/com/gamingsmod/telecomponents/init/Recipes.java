package com.gamingsmod.telecomponents.init;

import com.gamingsmod.telecomponents.recipes.ShapedRecipes;
import com.gamingsmod.telecomponents.recipes.ShapelessRecipes;
import com.gamingsmod.telecomponents.utility.LogHelper;

public class Recipes
{
    public static void init()
    {
        ShapelessRecipes.init();
        ShapedRecipes.init();

        LogHelper.info("Loaded Recipes");
    }
}
