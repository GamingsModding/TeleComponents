package com.gamingsmod.telecomponents.common;

import com.gamingsmod.telecomponents.common.init.*;
import com.gamingsmod.telecomponents.common.network.GuiHandler;
import com.gamingsmod.telecomponents.common.utility.LogHelper;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

import java.net.NetworkInterface;

public class CommonProxy
{
    public void preinit(FMLPreInitializationEvent e)
    {
        ModItems.init();
        ModTools.init();
        ModArmor.init();
        ModBlocks.init();
        ModTileEntities.init();
        LogHelper.info("Pre Initialization Complete");
    }

    public void init(FMLInitializationEvent e)
    {
        Recipes.init();
        NetworkRegistry.INSTANCE.registerGuiHandler(TeleComponents.instance, new GuiHandler());
        LogHelper.info("Initalization Complete");
    }

    public void postinit(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initalization Complete");
    }
}
