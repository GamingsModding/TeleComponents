package com.gamingsmod.telecomponents.common.network;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
    public static final int MOD_TELE_BLOCK_ID = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        /*switch (ID) {
            case MOD_TELE_BLOCK_ID:
                return new ContainerTeleBlock();
        }*/
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        /*switch (ID) {
            case MOD_TELE_BLOCK_ID:
                return new GuiTeleBlock();
        }*/
        return null;
    }
}
