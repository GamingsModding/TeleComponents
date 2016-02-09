package com.gamingsmod.telecomponents.client.render.items;

import com.gamingsmod.telecomponents.common.init.ModArmor;
import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.init.ModTools;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

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
        registerCustom(ModItems.enderPearlGun, new ItemMeshDefinition(){

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack) {
                int cooldown = stack.getItemDamage();

                if (cooldown >= (stack.getMaxDamage() / 4 * 3))
                    return new ModelResourceLocation(Reference.MOD_ID + ":" + stack.getItem().getUnlocalizedName().substring(20) + "_3", "inventory");
                else if (cooldown >= (stack.getMaxDamage() / 4 * 2))
                    return new ModelResourceLocation(Reference.MOD_ID + ":" + stack.getItem().getUnlocalizedName().substring(20) + "_2", "inventory");
                else if (cooldown >= (stack.getMaxDamage() / 4))
                    return new ModelResourceLocation(Reference.MOD_ID + ":" + stack.getItem().getUnlocalizedName().substring(20) + "_1", "inventory");
                else
                    return new ModelResourceLocation(Reference.MOD_ID + ":" + stack.getItem().getUnlocalizedName().substring(20), "inventory");
            }
        });
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
