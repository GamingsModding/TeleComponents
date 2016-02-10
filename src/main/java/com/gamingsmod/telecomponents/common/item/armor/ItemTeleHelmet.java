package com.gamingsmod.telecomponents.common.item.armor;

import com.gamingsmod.telecomponents.common.reference.ArmorType;
import com.gamingsmod.telecomponents.common.reference.Material;

public class ItemTeleHelmet extends ItemArmorTeleC
{
    public ItemTeleHelmet()
    {
        super(Material.Armor.TELEINGOT, ArmorType.HELMET, "Gives Night Vision");
        this.setUnlocalizedName("teleIngotHelmet");
    }
}
