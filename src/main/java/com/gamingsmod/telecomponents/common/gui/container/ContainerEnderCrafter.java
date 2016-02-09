package com.gamingsmod.telecomponents.common.gui.container;

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
         * Tile Entity TeleBlock    Number of Slots: 10      Slot IDs: 0-9
         * Player Inventory         Number of Slots: 27     Slot IDs: 9-36
         * Player Hotbar            Number of Slots: 9      Slot IDs: 36-45
         */

        this.te = tileEntity;

        //Crafting Grid
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                this.addSlotToContainer(new Slot(te, x + y * 3, 30 + y * 18, 17 + x * 18));
            }
        }

        this.addSlotToContainer(new SlotEnderPearls(te, 9, 93, 53));

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
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
        ItemStack previous = null;
        Slot slot = (Slot) this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack()) {
            ItemStack current = slot.getStack();
            previous = current.copy();

            if (fromSlot < 9) {
                // From TE Inventory to Player Inventory
                if (!this.mergeItemStack(current, 9, 45, true))
                    return null;
            } else {
                // From Player Inventory to TE Inventory
                if (!this.mergeItemStack(current, 0, 9, false))
                    return null;
            }

            if (current.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (current.stackSize == previous.stackSize)
                return null;
            slot.onPickupFromSlot(playerIn, current);
        }
        return previous;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.te.isUsableByPlayer(player);
    }

    private class SlotEnderPearls extends Slot
    {

        public SlotEnderPearls(IInventory inventoryIn, int index, int xPosition, int yPosition) {
            super(inventoryIn, index, xPosition, yPosition);
        }

        @Override
        public boolean isItemValid(ItemStack item)
        {
            return (item.getItem() instanceof ItemEnderPearl);
        }
    }
}

