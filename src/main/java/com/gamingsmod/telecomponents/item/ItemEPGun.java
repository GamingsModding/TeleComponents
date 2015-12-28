package com.gamingsmod.telecomponents.item;

import com.gamingsmod.telecomponents.reference.Reference;
import com.gamingsmod.telecomponents.utility.NBTHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemEPGun extends ItemTeleC
{
    private static final String[] ICONS = {"enderPearlGun_3", "enderPearlGun_2", "enderPearlGun_1", "enderPearlGun"};
    public static final String COOLDOWN_NAME = "cooldown";
    public static int COOLDOWN_LENGTH = 50;

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemEPGun()
    {
        super();
        this.setUnlocalizedName("enderPearlGun");
        this.setMaxStackSize(1);
//        this.setMaxDamage(255);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!world.isRemote)
        {
            int cooldown = NBTHelper.getInt(stack, COOLDOWN_NAME);

            if(cooldown == 0)
            {
                world.spawnEntityInWorld(new EntityEnderPearl(world, player));
//                stack.damageItem(1, player);
                NBTHelper.setInteger(stack, COOLDOWN_NAME, COOLDOWN_LENGTH);
                world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            }
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int int1, boolean bool1)
    {
        int cooldown = NBTHelper.getInt(stack, COOLDOWN_NAME);

        if (cooldown > 0)
        {
            cooldown = cooldown - 1;
            NBTHelper.setInteger(stack, COOLDOWN_NAME, cooldown);
//            LogHelper.info("Cooldown: " + cooldown);
            if(cooldown == 0)
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
        int cooldown = NBTHelper.getInt(stack, COOLDOWN_NAME);
        if (cooldown >= (COOLDOWN_LENGTH / 4 * 3))
            return icons[0];
        else if (cooldown >= (COOLDOWN_LENGTH / 4 * 2))
            return icons[1];
        else if (cooldown >= (COOLDOWN_LENGTH / 4))
            return icons[2];
        else
            return icons[3];
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool1)
    {
        int cooldown = NBTHelper.getInt(stack, COOLDOWN_NAME);
        list.add("Cooldown: " + cooldown + "/" + COOLDOWN_LENGTH);
    }
}
