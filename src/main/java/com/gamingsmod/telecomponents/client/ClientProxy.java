package com.gamingsmod.telecomponents.client;

import com.gamingsmod.telecomponents.client.render.BlockRenderRegister;
import com.gamingsmod.telecomponents.client.render.ItemRenderRegister;
import com.gamingsmod.telecomponents.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class ClientProxy extends CommonProxy
{
    public void init(FMLInitializationEvent e)
    {
        super.init(e);

        BlockRenderRegister.init();
        ItemRenderRegister.init();
    }
}
