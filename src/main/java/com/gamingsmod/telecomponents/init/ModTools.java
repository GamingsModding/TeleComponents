package com.gamingsmod.telecomponents.init;

import com.gamingsmod.telecomponents.item.tools.*;
import com.gamingsmod.telecomponents.reference.Material;
import com.gamingsmod.telecomponents.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModTools
{
    public static final Item toolTelePickaxe = new ItemTelePickaxe(Material.Tools.TELEINGOT);
    public static final Item toolTeleSword = new ItemTeleSword(Material.Tools.TELEINGOT);
    public static final Item toolTeleSpade = new ItemTeleSpade(Material.Tools.TELEINGOT);
    public static final Item toolTeleAxe = new ItemTeleAxe(Material.Tools.TELEINGOT);
    public static final Item toolTeleHoe = new ItemTeleHoe(Material.Tools.TELEINGOT);

    public static void init()
    {
        GameRegistry.registerItem(toolTelePickaxe, "teleIngotPickaxe");
        GameRegistry.registerItem(toolTeleSword, "teleIngotSword");
        GameRegistry.registerItem(toolTeleSpade, "teleIngotSpade");
        GameRegistry.registerItem(toolTeleAxe, "teleIngotAxe");
        GameRegistry.registerItem(toolTeleHoe, "teleIngotHoe");
    }
}
