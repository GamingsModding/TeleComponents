package com.gamingsmod.telecomponents.common.creativetab;

import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabTeleC
{
    public static final CreativeTabs TELEC_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ModItems.teleIngot;
        }
    };
}
