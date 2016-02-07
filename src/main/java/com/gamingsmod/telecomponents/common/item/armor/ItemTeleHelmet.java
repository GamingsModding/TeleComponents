package com.gamingsmod.telecomponents.common.item.armor;

import com.gamingsmod.telecomponents.common.reference.ArmorType;

public class ItemTeleHelmet extends ItemArmorTeleC
{
    public ItemTeleHelmet(ArmorMaterial material)
    {
        super(material, ArmorType.HELMET, "Gives Night Vision");
        this.setUnlocalizedName("teleIngotHelmet");
    }
}
