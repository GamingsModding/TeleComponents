package com.gamingsmod.telecomponents.client.render.items;

import com.gamingsmod.telecomponents.common.init.ModArmor;
import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.init.ModTools;
import com.gamingsmod.telecomponents.common.item.ItemEPGun;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public final class ItemRenderRegister
{
    public static void init()
    {
        register(ModItems.teleIngot);
        register(ModItems.enderStick);
        register(ModItems.epCreationCore);
        register(ModItems.telePos);
        register(ModItems.portTeleport);
        register(ModItems.obsidianChunk);

        // Tools
        register(ModTools.toolTeleAxe);
        register(ModTools.toolTeleHoe);
        register(ModTools.toolTeleSpade);
        register(ModTools.toolTeleSword);
        register(ModTools.toolTelePickaxe);

        // Armor
        register(ModArmor.teleIngotHelmet);
        register(ModArmor.teleIngotChest);
        register(ModArmor.teleIngotLegs);
        register(ModArmor.teleIngotBoots);

        // Ender Pearl Gun
        registerCustom(ModItems.enderPearlGun, ItemEPGun.registerMesh());
    }

    private static void register(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(20), "inventory"));
    }

    private static void registerCustom(Item item, ItemMeshDefinition mesh)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(item, mesh);
    }
}
