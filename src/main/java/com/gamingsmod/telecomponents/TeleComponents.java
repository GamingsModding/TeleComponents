package com.gamingsmod.telecomponents;

import com.gamingsmod.telecomponents.init.*;
import com.gamingsmod.telecomponents.proxy.IProxy;
import com.gamingsmod.telecomponents.reference.Reference;
import com.gamingsmod.telecomponents.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class TeleComponents
{
    @Mod.Instance(Reference.MOD_ID)
    public static TeleComponents instance;

    @SidedProxy(clientSide = Reference.CLIENT_SIDE_PROXY, serverSide = Reference.SERVER_SIDE_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        ModItems.init();
        ModTools.init();
        ModArmor.init();
        ModBlocks.init();
        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        Recipes.init();

        LogHelper.info("Initalization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initialization Complete");
    }
}
