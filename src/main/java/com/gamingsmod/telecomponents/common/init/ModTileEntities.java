package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.reference.Reference;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityEnderCrafting;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityTeleBlock.class, Reference.MOD_NAME + "_TEteleBlock");
        GameRegistry.registerTileEntity(TileEntityEnderCrafting.class, Reference.MOD_NAME + "_TEenderCrafting");
    }
}
