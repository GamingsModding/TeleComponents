package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.block.*;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModBlocks
{
    public static final BlockTeleC teleIngotBlock = new BlockTeleIngot();
    public static final BlockContainerTeleC teleBlock = new BlockTeleBlock();
    public static final BlockContainerTeleC enderCrafter = new BlockEnderCrafter();
    public static final BlockTeleC compressedEndStone = new BlockCompressedEndStone();

    public static void init()
    {
        GameRegistry.registerBlock(teleIngotBlock, "teleIngotBlock");
        GameRegistry.registerBlock(teleBlock, "teleBlock");
        GameRegistry.registerBlock(enderCrafter, "enderCrafter");
        GameRegistry.registerBlock(compressedEndStone, "compressedEndStone");
    }
}
