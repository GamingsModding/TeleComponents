package com.gamingsmod.telecomponents.client.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNoFallPearl implements IRenderFactory
{
    private static final ResourceLocation resourceLocation = new ResourceLocation("minecraft:items/ender_pearl.png");

    @Override
    public Render createRenderFor(RenderManager manager)
    {
        return new Render(manager)
        {
            @Override
            protected ResourceLocation getEntityTexture(Entity entity)
            {
                return resourceLocation;
            }
        };
    }
}
