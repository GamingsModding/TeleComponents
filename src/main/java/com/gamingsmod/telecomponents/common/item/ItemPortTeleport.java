package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.utility.LogHelper;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemPortTeleport extends ItemTeleC
{
    public ItemPortTeleport()
    {
        super();
        this.setUnlocalizedName("portTeleportDevice");
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote) {
            if (stack.getItemDamage() == 0) {
                int xCoord = NBTHelper.getInt(stack, "xCoord");
                int yCoord = NBTHelper.getInt(stack, "yCoord");
                int zCoord = NBTHelper.getInt(stack, "zCoord");
                Block block1 = world.getBlock(xCoord, yCoord, zCoord);
                Block block2 = world.getBlock(xCoord, yCoord + 1, zCoord);
                stack.damageItem(499, player);

                if (yCoord > 0) {
                    if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                        if ((!(block1 instanceof BlockStaticLiquid) && !(block2 instanceof BlockStaticLiquid))) {
                            player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                            return stack;
                        }
                    }

                    player.addChatComponentMessage(new ChatComponentText("Teleport failed").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
                }
            }
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity player, int int1, boolean bool1) {
       if (stack.getItemDamage() < stack.getMaxDamage())
           stack.setItemDamage(stack.getItemDamage() - 1);
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bol1)
    {
        int x = NBTHelper.getInt(itemStack, "xCoord");
        int y = NBTHelper.getInt(itemStack, "yCoord");
        int z = NBTHelper.getInt(itemStack, "zCoord");
        list.add("X: " + x);
        list.add("Y: " + y);
        list.add("Z: " + z);
    }
}
