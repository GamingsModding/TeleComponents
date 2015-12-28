package com.gamingsmod.telecomponents.item.armor;

import com.gamingsmod.telecomponents.reference.ArmorType;

public class ItemTeleHelmet extends ItemArmorTeleC
{
    public ItemTeleHelmet(ArmorMaterial material)
    {
        super(material, ArmorType.HELMET, "Gives Night Vision");
        this.setUnlocalizedName("teleIngotHelmet");
    }
}
