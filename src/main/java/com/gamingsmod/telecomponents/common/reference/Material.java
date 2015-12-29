package com.gamingsmod.telecomponents.common.reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class Material
{
    public static final class Tools
    {
        public static final Item.ToolMaterial TELEINGOT = EnumHelper.addToolMaterial("teleingot", 3, 3200, 15, 8, 30);
    }

    public static final class Armor
    {
        public static final ItemArmor.ArmorMaterial TELEINGOT = EnumHelper.addArmorMaterial("teleingot", 40, new int[]{4, 9, 7, 4}, 30);
    }
}
