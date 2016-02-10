package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.item.tools.*;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModTools
{
    public static final Item toolTelePickaxe = new ItemTelePickaxe();
    public static final Item toolTeleSword = new ItemTeleSword();
    public static final Item toolTeleSpade = new ItemTeleSpade();
    public static final Item toolTeleAxe = new ItemTeleAxe();
    public static final Item toolTeleHoe = new ItemTeleHoe();

    public static void init()
    {
        GameRegistry.registerItem(toolTelePickaxe, "teleIngotPickaxe");
        GameRegistry.registerItem(toolTeleSword, "teleIngotSword");
        GameRegistry.registerItem(toolTeleSpade, "teleIngotSpade");
        GameRegistry.registerItem(toolTeleAxe, "teleIngotAxe");
        GameRegistry.registerItem(toolTeleHoe, "teleIngotHoe");
    }
}
