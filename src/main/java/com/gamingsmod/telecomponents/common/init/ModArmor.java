package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.item.armor.*;
import com.gamingsmod.telecomponents.common.reference.Material;
import com.gamingsmod.telecomponents.common.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModArmor
{
    public static final ItemArmorTeleC teleIngotHelmet = new ItemTeleHelmet(Material.Armor.TELEINGOT);
    public static final ItemArmorTeleC teleIngotChest = new ItemTeleChest(Material.Armor.TELEINGOT);
    public static final ItemArmorTeleC teleIngotLegs = new ItemTeleLegs(Material.Armor.TELEINGOT);
    public static final ItemArmorTeleC teleIngotBoots = new ItemTeleBoots(Material.Armor.TELEINGOT);

    public static void init()
    {
        GameRegistry.registerItem(teleIngotHelmet, "teleIngotHelmet");
        GameRegistry.registerItem(teleIngotChest, "teleIngotChest");
        GameRegistry.registerItem(teleIngotLegs, "teleIngotLegs");
        GameRegistry.registerItem(teleIngotBoots, "teleIngotBoots");
    }
}
