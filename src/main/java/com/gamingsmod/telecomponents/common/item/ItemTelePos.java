package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.List;

public class ItemTelePos extends ItemTeleC
{
    public ItemTelePos()
    {
        super();
        this.setUnlocalizedName("telePositionPointer");
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        NBTHelper.setInteger(itemStack, "xCoord", pos.getX());
        NBTHelper.setInteger(itemStack, "yCoord", pos.getY() + 1);
        NBTHelper.setInteger(itemStack, "zCoord", pos.getZ());
        NBTHelper.setInteger(itemStack, "dimNum", player.dimension);

        player.addChatComponentMessage(new ChatComponentText("Coordinates set to: X: " + pos.getX() + ", Y: " + (pos.getY() + 1) + ", Z: " + pos.getZ()).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
        this.onItemRightClick(itemStack, world, player);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bol1)
    {
        int x = NBTHelper.getInt(itemStack, "xCoord");
        int y = NBTHelper.getInt(itemStack, "yCoord");
        int z = NBTHelper.getInt(itemStack, "zCoord");
        int dim = NBTHelper.getInt(itemStack, "dimNum");
        list.add("X: " + x);
        list.add("Y: " + y);
        list.add("Z: " + z);
        list.add("Dimension: " + dim);
    }
}