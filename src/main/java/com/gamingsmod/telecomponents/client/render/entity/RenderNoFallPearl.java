package com.gamingsmod.telecomponents.client.render.entity;

import com.gamingsmod.telecomponents.common.entity.EntityNoFallPearl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNoFallPearl extends RenderSnowball<EntityNoFallPearl>
{
    public RenderNoFallPearl(RenderManager manager)
    {
        super(manager, Items.ender_pearl, Minecraft.getMinecraft().getRenderItem());
    }
}