package com.gamingsmod.telecomponents.common.tileentity;

import com.gamingsmod.telecomponents.common.helper.TeleportHelper;
import com.gamingsmod.telecomponents.common.item.ItemTelePos;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

// Code adapted from BedrockMiner because I am an idiot
// @source http://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/tile-entity-with-inventory/

public class TileEntityTeleBlock extends TileEntity implements IInventory, ITickable
{
    private ItemStack[] inventory;
    private String customName;
    private String placedBy;

    private int previousRedstoneInput;

    public TileEntityTeleBlock()
    {
        this.inventory = new ItemStack[this.getSizeInventory()];
    }

    public String getCustomName()
    {
        return this.customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public void setPlayerName(String name)
    {
        this.placedBy = name;
    }

    public String getPlayerName()
    {
        return this.placedBy;
    }

    @Override
    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.teleBlock";
    }

    @Override
    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.equals("");
    }

    @Override
    public IChatComponent getDisplayName()
    {
        return this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory()
    {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).stackSize <= count){
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).stackSize <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        if (index < 0 || index >= this.getSizeInventory())
            return;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();

        if (stack != null && stack.stackSize == 0)
            stack = null;

        this.inventory[index] = stack;
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 1;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {}

    @Override
    public void closeInventory(EntityPlayer player) {}

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return stack.getItem() instanceof ItemTelePos;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value) {}

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < this.getSizeInventory(); i++)
            this.setInventorySlotContents(i, null);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        NBTTagList list = new NBTTagList();
        for (int i = 0; i < this.getSizeInventory(); ++i) {
            if (this.getStackInSlot(i) != null) {
                NBTTagCompound stackTag = new NBTTagCompound();
                stackTag.setByte("Slot", (byte) i);
                this.getStackInSlot(i).writeToNBT(stackTag);
                list.appendTag(stackTag);
            }
        }
        nbt.setTag("Items", list);

        if (this.hasCustomName()) {
            nbt.setString("CustomName", this.getCustomName());
        }
    }


    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        NBTTagList list = nbt.getTagList("Items", 10);
        for (int i = 0; i < list.tagCount(); ++i) {
            NBTTagCompound stackTag = list.getCompoundTagAt(i);
            int slot = stackTag.getByte("Slot") & 255;
            this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
        }

        if (nbt.hasKey("CustomName", 8)) {
            this.setCustomName(nbt.getString("CustomName"));
        }
    }

    @Override
    public void update()
    {
        if (!worldObj.isRemote) {
            int currentInput = worldObj.getStrongPower(pos);
            EntityPlayer player = worldObj.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5);
            if (previousRedstoneInput == 0 && currentInput != 0)
            {
                TileEntityTeleBlock teleBlock = (TileEntityTeleBlock) worldObj.getTileEntity(pos);
                ItemStack item = teleBlock.getStackInSlot(0);
                if (item != null) {
                    int xCoord = NBTHelper.getInt(item, "xCoord");
                    int yCoord = NBTHelper.getInt(item, "yCoord");
                    int zCoord = NBTHelper.getInt(item, "zCoord");
                    int dimNum = NBTHelper.getInt(item, "dimNum");
                    World worldTo =  DimensionManager.getWorld(dimNum);

                    Block block1 = worldObj.getBlockState(new BlockPos(xCoord, yCoord, zCoord)).getBlock();
                    Block block2 = worldObj.getBlockState(new BlockPos(xCoord, yCoord + 1, zCoord)).getBlock();

                    if (yCoord > 0) {
                        if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                            if (worldTo.equals(worldObj)) {
                                player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                                worldObj.playSoundEffect(xCoord, yCoord, zCoord, "mob.endermen.portal", 1.0F, 1.0F);
                            } else {
                                TeleportHelper.teleportEntityToDim(worldObj, dimNum, xCoord + .5, yCoord, zCoord + .5, player);
                            }
                        }
                    }
                }            }

            previousRedstoneInput = currentInput;
        }
    }
}
