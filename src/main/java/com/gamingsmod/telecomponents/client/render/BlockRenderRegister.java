package com.gamingsmod.telecomponents.client.render;

import com.gamingsmod.telecomponents.common.block.BlockCompressedEndStone;
import com.gamingsmod.telecomponents.common.block.BlockTeleBlock;
import com.gamingsmod.telecomponents.common.block.BlockTeleIngot;
import com.gamingsmod.telecomponents.common.init.ModBlocks;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister
{
    public static void init()
    {
        register(ModBlocks.compressedEndStone);
        register(ModBlocks.teleIngotBlock);
        register(ModBlocks.teleBlock);

    }

    private static void register(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
    }
}
