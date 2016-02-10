package com.gamingsmod.telecomponents.common.handler;

import com.gamingsmod.telecomponents.common.utility.LogHelper;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static int ENDER_PEARL_GUN_COOLDOWN = 50;

    public static void init(File configFile)
    {
        Configuration configuration = new Configuration(configFile);

        try
        {
            //Load the configuration file
            configuration.load();

            //Load properties from config file
            ENDER_PEARL_GUN_COOLDOWN = configuration.get(Configuration.CATEGORY_GENERAL, "enderPearlGunCooldown", 50, "The number of ticks which the ender pearl gun takes to cooldown").getInt();
        } catch (Exception e) {
            //Output error in the run log
            LogHelper.error("Configuration Load Error: " + e.getMessage());
        } finally {
            //Save configuration file
            if (configuration.hasChanged())
                configuration.save();
        }
        System.out.println("Configuration Handler: " + ENDER_PEARL_GUN_COOLDOWN);
    }
}
