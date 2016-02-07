package com.gamingsmod.telecomponents.common.init;

import com.gamingsmod.telecomponents.common.item.*;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public final class ModItems
{
    public static final ItemTeleC teleIngot = new ItemTeleIngot();
    public static final ItemTeleC enderPearlGun = new ItemEPGun();
    public static final ItemTeleC enderStick = new ItemEnderStick();
    public static final ItemTeleC epCreationCore = new ItemEPCreationCore();
    public static final ItemTeleC telePos = new ItemTelePos();
    public static final ItemTeleC portTeleport = new ItemPortTeleport();
    public static final ItemTeleC obsidianChunk = new ItemObsidianChunk();

    public static void init()
    {
        GameRegistry.registerItem(teleIngot, "teleIngot");
        GameRegistry.registerItem(enderPearlGun, "enderPearlGun");
        GameRegistry.registerItem(enderStick, "enderStick");
        GameRegistry.registerItem(epCreationCore, "enderPearlCreationCore");
        GameRegistry.registerItem(telePos, "telePositionPointer");
        GameRegistry.registerItem(portTeleport, "portTeleportDevice");
        GameRegistry.registerItem(obsidianChunk, "obsidianChunk");
    }
}
