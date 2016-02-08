package com.gamingsmod.telecomponents.client;

import com.gamingsmod.telecomponents.client.render.blocks.BlockRenderRegister;
import com.gamingsmod.telecomponents.client.render.items.ItemRenderRegister;
import com.gamingsmod.telecomponents.common.CommonProxy;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preinit(FMLPreInitializationEvent e) {
        super.preinit(e);
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);

        BlockRenderRegister.init();
        ItemRenderRegister.init();
    }
}
