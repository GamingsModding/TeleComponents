package com.gamingsmod.telecomponents.init;

import com.gamingsmod.telecomponents.item.*;
import com.gamingsmod.telecomponents.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemTeleC teleIngot = new ItemTeleIngot();
    public static final ItemTeleC enderPearlGun = new ItemEPGun();
    public static final ItemTeleC enderStick = new ItemEnderStick();
    public static final ItemTeleC epCreationCore = new ItemEPCreationCore();

    public static void init()
    {
        GameRegistry.registerItem(teleIngot, "teleIngot");
        GameRegistry.registerItem(enderPearlGun, "enderPearlGun");
        GameRegistry.registerItem(enderStick, "enderStick");
        GameRegistry.registerItem(epCreationCore, "enderPearlCreationCore");
    }
}
