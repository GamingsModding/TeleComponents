package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.utility.LogHelper;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class ItemPortTeleport extends ItemTeleC
{
    public ItemPortTeleport()
    {
        super();
        this.setUnlocalizedName("portTeleportDevice");
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote) {
            int xCoord = NBTHelper.getInt(stack, "xCoord");
            int yCoord = NBTHelper.getInt(stack, "yCoord");
            int zCoord = NBTHelper.getInt(stack, "zCoord");
            System.out.println(xCoord + ", " + yCoord + ", " + zCoord);
            Block block1 = world.getBlock(xCoord, yCoord, zCoord);
            System.out.println(block1.toString());
            Block block2 = world.getBlock(xCoord, yCoord + 1, zCoord);
            System.out.println(block1.toString());

            if (yCoord > 0) {
                if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                    if ((!(block1 instanceof BlockStaticLiquid) && !(block2 instanceof BlockStaticLiquid))) {
                        player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                    }
                }
            }
        }
        return stack;
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
