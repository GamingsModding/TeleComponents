package com.gamingsmod.telecomponents.common.item;

//TODO: Hide tooltip until set

import com.gamingsmod.telecomponents.common.helper.TeleportHelper;
import com.gamingsmod.telecomponents.common.helper.TimeHelper;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

import java.util.List;

public class ItemPortTeleport extends ItemTeleC {
    public ItemPortTeleport() {
        super();
        this.setUnlocalizedName("portTeleportDevice");
        this.setMaxStackSize(1);
        this.setMaxDamage(500);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            if (stack.getItemDamage() == 0) {
                int xCoord = NBTHelper.getInt(stack, "xCoord");
                int yCoord = NBTHelper.getInt(stack, "yCoord");
                int zCoord = NBTHelper.getInt(stack, "zCoord");
                int dimNum = NBTHelper.getInt(stack, "dimNum");
                World worldTo = DimensionManager.getWorld(dimNum);
                Block block1 = worldTo.getBlockState(new BlockPos(xCoord, yCoord, zCoord)).getBlock();
                Block block2 = worldTo.getBlockState(new BlockPos(xCoord, yCoord + 1, zCoord)).getBlock();
                stack.damageItem(499, player);

                if (yCoord > 0) {
                    if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                        if ((!(block1 instanceof BlockStaticLiquid) && !(block2 instanceof BlockStaticLiquid))) {
                            if (worldTo.equals(world)) {
                                player.worldObj = worldTo;
                                player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                                world.playSoundEffect(xCoord, yCoord, zCoord, "mob.endermen.portal", 1.0F, 1.0F);
                            } else {
                                if (player.timeUntilPortal > 0)
                                    player.addChatComponentMessage(new ChatComponentText("Teleport failed: Please wait " + TimeHelper.ticksToSeconds(player.timeUntilPortal) + " second(s) to teleport").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
                                else
                                    TeleportHelper.teleportEntityToDim(world, dimNum, xCoord, yCoord, zCoord, player);
                            }
                            return stack;
                        }
                    }

                    player.addChatComponentMessage(new ChatComponentText("Teleport failed").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
                }
            } else {
                player.addChatComponentMessage(new ChatComponentText("Teleport failed: Cooldown in progress, please wait " + TimeHelper.ticksToSeconds(stack.getItemDamage()) + " second(s)").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
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
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean bol1) {
        int x = NBTHelper.getInt(itemStack, "xCoord");
        int y = NBTHelper.getInt(itemStack, "yCoord");
        int z = NBTHelper.getInt(itemStack, "zCoord");
        int dim = NBTHelper.getInt(itemStack, "dimNum");
        boolean coordsSet = NBTHelper.getBoolean(itemStack, "coordsSet");

        if (coordsSet) {
            WorldProvider targetWorld = WorldProvider.getProviderForDimension(dim);

            list.add("X: " + x);
            list.add("Y: " + y);
            list.add("Z: " + z);
            list.add("Dimension: " + dim + " (" + targetWorld.getDimensionName() + ")");
        }
    }
}
