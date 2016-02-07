package com.gamingsmod.telecomponents.common.network;

import com.gamingsmod.telecomponents.client.gui.inventory.GuiTeleBlock;
import com.gamingsmod.telecomponents.common.gui.container.ContainerTeleBlock;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    public static final int MOD_TELE_BLOCK_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case MOD_TELE_BLOCK_ID:
                return new ContainerTeleBlock(player.inventory, (TileEntityTeleBlock) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case MOD_TELE_BLOCK_ID:
                return new GuiTeleBlock(player.inventory, (TileEntityTeleBlock) world.getTileEntity(new BlockPos(x, y, z)));
        }
        return null;
    }
}
