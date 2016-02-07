package com.gamingsmod.telecomponents.common;

import com.gamingsmod.telecomponents.common.handler.ConfigurationHandler;
import com.gamingsmod.telecomponents.common.init.*;
import com.gamingsmod.telecomponents.common.network.GuiHandler;
import com.gamingsmod.telecomponents.common.override.BlockOverride;
import com.gamingsmod.telecomponents.common.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy
{
    public void preinit(FMLPreInitializationEvent e)
    {
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());

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
        MinecraftForge.EVENT_BUS.register(new BlockOverride());

        OreDictionary.registerOre("ingotTeleIngot", ModItems.teleIngot);
        OreDictionary.registerOre("blockTeleIngot", ModBlocks.teleIngotBlock);
        OreDictionary.registerOre("compressedEndStone", ModBlocks.compressedEndStone);
        OreDictionary.registerOre("nuggetObsidian", ModItems.obsidianChunk);

        LogHelper.info("Initalization Complete");
    }

    public void postinit(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initalization Complete");
    }
}
