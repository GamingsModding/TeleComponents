package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.recipes.*;
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
