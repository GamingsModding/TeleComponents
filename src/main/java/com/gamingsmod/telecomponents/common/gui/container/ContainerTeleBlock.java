package com.gamingsmod.telecomponents.common.gui.container;

import com.gamingsmod.telecomponents.common.block.BlockContainerTeleC;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;

public class ContainerTeleBlock extends Container
{
    private TileEntityTeleBlock te;

    public ContainerTeleBlock(IInventory player, TileEntityTeleBlock te)
    {
        this.te = te;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.te.isUseableByPlayer(player);
    }
}
