package com.gamingsmod.telecomponents.init;

import com.gamingsmod.telecomponents.block.*;
import com.gamingsmod.telecomponents.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockTeleC teleIngotBlock = new BlockTeleIngot();
    public static final BlockTeleC compressedEndStone = new BlockCompressedEndStone();

    public static void init()
    {
        GameRegistry.registerBlock(teleIngotBlock, "teleIngotBlock");
        GameRegistry.registerBlock(compressedEndStone, "compressedEndStone");
    }
}
