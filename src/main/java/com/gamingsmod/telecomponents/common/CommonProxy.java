package com.gamingsmod.telecomponents.common;

import com.gamingsmod.telecomponents.common.init.*;
import com.gamingsmod.telecomponents.common.utility.LogHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preinit(FMLPreInitializationEvent e)
    {
        ModItems.init();
        ModTools.init();
        ModArmor.init();
        ModBlocks.init();
        LogHelper.info("Pre Initialization Complete");
    }

    public void init(FMLInitializationEvent e)
    {
        Recipes.init();

        LogHelper.info("Initalization Complete");
    }

    public void postinit(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initalization Complete");
    }
}
