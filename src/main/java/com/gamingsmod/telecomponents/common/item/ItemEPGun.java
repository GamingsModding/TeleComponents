package com.gamingsmod.telecomponents.common.item;

import com.gamingsmod.telecomponents.common.handler.ConfigurationHandler;
import com.gamingsmod.telecomponents.common.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemEPGun extends ItemTeleC
{
    private static final String[] ICONS = {"enderPearlGun_3", "enderPearlGun_2", "enderPearlGun_1", "enderPearlGun"};

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemEPGun()
    {
        super();
        this.setUnlocalizedName("enderPearlGun");
        this.setMaxStackSize(1);
        this.setMaxDamage(ConfigurationHandler.ENDER_PEARL_GUN_COOLDOWN);
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
                world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            }
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int int1, boolean bool1)
    {
        if (stack.getItemDamage() < stack.getMaxDamage()) {
            stack.setItemDamage(stack.getItemDamage() - 1);
            if(stack.getItemDamage() == 0)
                world.playSoundAtEntity(entity, "random.levelup", 1, 1);
        }

    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[ICONS.length];

        for (int i = 0; i < ICONS.length; i++)
        {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + ICONS[i]);
        }
    }

    @Override
    public IIcon getIcon(ItemStack stack, int renderpass)
    {
        int cooldown = stack.getItemDamage();
        if (cooldown >= (stack.getMaxDamage() / 4 * 3))
            return icons[0];
        else if (cooldown >= (stack.getMaxDamage() / 4 * 2))
            return icons[1];
        else if (cooldown >= (stack.getMaxDamage() / 4))
            return icons[2];
        else
            return icons[3];
    }
}
