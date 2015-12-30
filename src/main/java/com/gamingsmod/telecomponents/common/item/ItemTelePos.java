package com.gamingsmod.telecomponents.common.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTelePos extends ItemTeleC
{
    public ItemTelePos()
    {
        super();
        this.setUnlocalizedName("telePositionPointer");
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int face, float flt1, float flt2, float flt3)
    {
        return false;
    }
}