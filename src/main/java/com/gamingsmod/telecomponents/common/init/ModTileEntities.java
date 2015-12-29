package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.reference.Reference;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntityTeleBlock.class, Reference.MOD_NAME + "_TEteleBlock");
    }
}
