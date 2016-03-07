package com.gamingsmod.telecomponents.client.render.blocks;

import com.gamingsmod.telecomponents.common.init.ModBlocks;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class BlockRenderRegister
{
    public static void init()
    {
        register(ModBlocks.teleIngotBlock);
        register(ModBlocks.teleBlock);
        register(ModBlocks.compressedEndStone);
        register(ModBlocks.enderCrafter);
    }

    private static void register(Block block)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID + ":" + block.getUnlocalizedName().substring(20), "inventory"));
    }
}
