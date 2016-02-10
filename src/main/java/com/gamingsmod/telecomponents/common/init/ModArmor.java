package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.item.armor.*;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModArmor
{
    public static final ItemArmorTeleC teleIngotHelmet = new ItemTeleHelmet();
    public static final ItemArmorTeleC teleIngotChest = new ItemTeleChest();
    public static final ItemArmorTeleC teleIngotLegs = new ItemTeleLegs();
    public static final ItemArmorTeleC teleIngotBoots = new ItemTeleBoots();

    public static void init()
    {
        GameRegistry.registerItem(teleIngotHelmet, "teleIngotHelmet");
        GameRegistry.registerItem(teleIngotChest, "teleIngotChest");
        GameRegistry.registerItem(teleIngotLegs, "teleIngotLegs");
        GameRegistry.registerItem(teleIngotBoots, "teleIngotBoots");
    }
}
