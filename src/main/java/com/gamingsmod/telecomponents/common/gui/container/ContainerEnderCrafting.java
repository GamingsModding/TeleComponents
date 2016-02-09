package com.gamingsmod.telecomponents.common.gui.container;

import com.gamingsmod.telecomponents.common.tileentity.TileEntityEnderCrafting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ContainerEnderCrafting extends Container
{
    private TileEntityEnderCrafting te;


    public ContainerEnderCrafting(IInventory player, TileEntityEnderCrafting tileEntity)
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

