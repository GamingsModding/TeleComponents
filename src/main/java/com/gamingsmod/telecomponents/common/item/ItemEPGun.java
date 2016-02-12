package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.entity.EntityNoFallPearl;
import com.gamingsmod.telecomponents.common.helper.TimeHelper;
import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemEPGun extends ItemTeleC {
    public ItemEPGun()
    {
        super();
        this.setUnlocalizedName("enderPearlGun");
        this.setMaxStackSize(1);
        this.setMaxDamage(50);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote) {
            int cooldown = stack.getItemDamage();

            if (cooldown == 0) {
                world.spawnEntityInWorld(new EntityNoFallPearl(world, player));
                stack.damageItem(49, player);
            } else player.addChatComponentMessage(new ChatComponentText("Summon Failed: Please wait " + TimeHelper.ticksToSeconds(cooldown) + " second(s) to fire.").setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int int1, boolean bool1)
    {
        if (stack.getItemDamage() < stack.getMaxDamage())
            stack.setItemDamage(stack.getItemDamage() - 1);

    }

    public static void registerIcons()
    {
        final String[] ICONS = {"enderPearlGun_3", "enderPearlGun_2", "enderPearlGun_1", "enderPearlGun"};

        for (int i = 0; i < ICONS.length; i++)
            ModelBakery.registerItemVariants(ModItems.enderPearlGun, new ResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + ICONS[i]));
    }

    public static ItemMeshDefinition registerMesh()
    {
        return new ItemMeshDefinition()
        {

            @Override
            public ModelResourceLocation getModelLocation(ItemStack stack)
            {
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
        };
    }
}
