package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

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
        NBTHelper.setInteger(itemStack, "x", x);
        NBTHelper.setInteger(itemStack, "y", y);
        NBTHelper.setInteger(itemStack, "z", z);

//        this.addInformation(itemStack, player);
        return true;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool1) {
        int x = NBTHelper.getInt(stack, "x");
        int y = NBTHelper.getInt(stack, "y");
        int z = NBTHelper.getInt(stack, "z");
        list.add("X: " + x);
        list.add("Y: " + y);
        list.add("Z: " + z);
    }
}