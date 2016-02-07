package com.gamingsmod.telecomponents.client.render;

import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.item.ItemEnderStick;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister
{
    public static void init()
    {
        register(ModItems.enderStick);

    }

    private static void register(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
