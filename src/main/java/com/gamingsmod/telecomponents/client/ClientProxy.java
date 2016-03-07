package com.gamingsmod.telecomponents.client;

import com.gamingsmod.telecomponents.client.render.blocks.BlockRenderRegister;
import com.gamingsmod.telecomponents.client.render.entity.RenderNoFallPearl;
import com.gamingsmod.telecomponents.client.render.items.ItemRenderRegister;
import com.gamingsmod.telecomponents.common.CommonProxy;
import com.gamingsmod.telecomponents.common.TeleComponents;
import com.gamingsmod.telecomponents.common.entity.EntityNoFallPearl;
import com.gamingsmod.telecomponents.common.item.ItemEPGun;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preinit(FMLPreInitializationEvent e) {
        super.preinit(e);

        ItemEPGun.registerIcons();
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);

        BlockRenderRegister.init();
        ItemRenderRegister.init();

        EntityRegistry.registerModEntity(EntityNoFallPearl.class, "NoFallPearl", 0, TeleComponents.instance, 10, 1, true);
        RenderingRegistry.registerEntityRenderingHandler(EntityNoFallPearl.class, (RenderManager manager) -> {return new RenderNoFallPearl(manager);});
    }
}
