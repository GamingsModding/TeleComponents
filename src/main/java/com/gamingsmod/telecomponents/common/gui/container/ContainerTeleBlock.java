package com.gamingsmod.telecomponents.common.gui.container;

import com.gamingsmod.telecomponents.common.item.ItemTelePos;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerTeleBlock extends Container
{
    private TileEntityTeleBlock te;

    public ContainerTeleBlock(IInventory player, TileEntityTeleBlock te)
    {
        /**
         * Tile Entity TeleBlock    Number of Slots: 1      Slot IDs: 0-0
         * Player Inventory         Number of Slots: 27     Slot IDs: 9-36
         * Player Hotbar            Number of Slots: 9      Slot IDs: 0-8
         */

        this.te = te;

        //TeleBlock
        this.addSlotToContainer(new SlotTeleBlock(te, 0, 80, 35));

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

    // Code copied from BedrockMiner and WayOfFollowingTime
    // @source https://github.com/WayofTime/BloodMagic/blob/277cd0742e1e19eae3ffc9a7a56e789a4a8826a6/src/main/java/WayofTime/alchemicalWizardry/common/tileEntity/container/ContainerTeleposer.java
    // @source http://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/gui-container/
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        int slots = inventorySlots.size();

        if (slotObject != null && slotObject.getHasStack())
        {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if (stack.getItem() instanceof ItemTelePos)
            {
                if (slot <= slots)
                {
                    if (!this.mergeItemStack(stackInSlot, 0, slots, false))
                    {
                        return null;
                    }
                }
                else if (!this.mergeItemStack(stackInSlot, slots, 36 + slots, false))
                {
                    return null;
                }
            }

            if (stackInSlot.stackSize == 0)
            {
                slotObject.putStack(null);
            } else
            {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize)
            {
                return null;
            }

            slotObject.onPickupFromSlot(player, stackInSlot);
        }

        return stack;
    }


    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.te.isUseableByPlayer(player);
    }

    private class SlotTeleBlock extends Slot
    {
        public SlotTeleBlock(IInventory invent, int id, int x, int y) {
            super(invent, id, x, y);
        }

        @Override
        public boolean isItemValid(ItemStack item)
        {
            return item.getItem() instanceof ItemTelePos;
        }
    }
}
