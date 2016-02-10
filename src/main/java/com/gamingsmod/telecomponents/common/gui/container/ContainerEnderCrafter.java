package com.gamingsmod.telecomponents.common.gui.container;

import com.gamingsmod.telecomponents.common.item.ItemTelePos;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityEnderCrafter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;

public class ContainerEnderCrafter extends Container
{
    private TileEntityEnderCrafter te;


    public ContainerEnderCrafter(IInventory player, TileEntityEnderCrafter tileEntity)
    {
        /**
         * EnderCrafter Crafting Grid   Number of Slots: 9      Slot IDs: 0-8
         * EnderCrafter Ender Slot      Number of Slots: 1      Slot IDs: 9-9
         * EnderCrafter Result Slot     Number of Slots: 1      Slot IDs: 10-10
         * Player Inventory             Number of Slots: 27     Slot IDs: 11-38
         * Player Hotbar                Number of Slots: 9      Slot IDs: 39-48
         */

        this.te = tileEntity;

        //Crafting Grid
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                this.addSlotToContainer(new Slot(te, x + y * 3, 30 + y * 18, 17 + x * 18));
            }
        }

        // ENDER POWER!! (Ender pearl slot)
        this.addSlotToContainer(new SlotEnderPearls(te, 9, 93, 53));

        // Result Slot
        this.addSlotToContainer(new SlotResult(te, 10, 123, 34));

        //Player inventory
        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                this.addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
            }
        }

        //Player Hotbar
        for (int x = 0; x < 9; ++x) {
            this.addSlotToContainer((new Slot(player, x, 8 + x * 18, 142)));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 10)
            {
                if (!this.mergeItemStack(itemstack1, 10, 46, true))
                    return null;
            }
            else {
                if (itemstack.getItem() instanceof ItemEnderPearl) {
                    if (!this.mergeItemStack(itemstack1, 9, 9, false))
                        return null;
                } else if (!this.mergeItemStack(itemstack1, 0, 9, false)) {
                    return null;
                }
            }
            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.te.isUsableByPlayer(player);
    }

    private class SlotEnderPearls extends Slot
    {

        public SlotEnderPearls(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack item)
        {
            return (item.getItem() instanceof ItemEnderPearl);
        }
    }

    private class SlotResult extends Slot
    {

        public SlotResult(IInventory inventoryIn, int index, int xPosition, int yPosition)
        {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack item)
        {
            return false;
        }
    }
}

