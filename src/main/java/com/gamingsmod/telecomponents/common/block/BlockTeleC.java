package com.gamingsmod.telecomponents.common.block;

import com.gamingsmod.telecomponents.common.creativetab.CreativeTabTeleC;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockTeleC extends Block
{
    public BlockTeleC(Material material)
    {
        super(material);
        this.setHardness(2.0F);
        this.setResistance(10);
        this.setCreativeTab(CreativeTabTeleC.TELEC_TAB);
    }

    public BlockTeleC()
    {
        this(Material.iron);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
