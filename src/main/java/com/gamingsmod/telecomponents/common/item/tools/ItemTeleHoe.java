package com.gamingsmod.telecomponents.common.item.tools;

import com.gamingsmod.telecomponents.common.creativetab.CreativeTabTeleC;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemTeleHoe extends ItemHoe
{
    public ItemTeleHoe(ToolMaterial material)
    {
        super(material);
        this.setUnlocalizedName("teleIngotHoe");
        this.setCreativeTab(CreativeTabTeleC.TELEC_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
