package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.handler.ConfigurationHandler;
import com.gamingsmod.telecomponents.common.init.ModItems;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemEPGun extends ItemTeleC
{
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
        if (!world.isRemote)
        {
            int cooldown = stack.getItemDamage();

            if(cooldown == 0)
            {
                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
                stack.damageItem(49, player);
            }
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
}
