package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;
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
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int face, float flt1, float flt2, float flt3)
    {
        NBTHelper.setInteger(itemStack, "xCoord", x);
        NBTHelper.setInteger(itemStack, "yCoord", y + 1);
        NBTHelper.setInteger(itemStack, "zCoord", z);

        player.addChatComponentMessage(new ChatComponentText("Coordinates set to: X: " + x + ", Y: " + (y + 1) + ", Z: " + z).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
        return true;
    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if (player.isSneaking())
        {
            int x = NBTHelper.getInt(itemStack, "xCoord");
            int y = NBTHelper.getInt(itemStack, "yCoord");
            int z = NBTHelper.getInt(itemStack, "zCoord");

            player.addChatComponentMessage(new ChatComponentText("Coordinates are set to: X: " + x + ", Y: " + y + ", Z: " + z).setChatStyle(new ChatStyle().setColor(EnumChatFormatting.LIGHT_PURPLE)));
        }

        return itemStack;
    }
}