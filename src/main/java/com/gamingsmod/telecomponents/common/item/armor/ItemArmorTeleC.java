package com.gamingsmod.telecomponents.common.item.armor;

import com.gamingsmod.telecomponents.common.creativetab.CreativeTabTeleC;
import com.gamingsmod.telecomponents.common.init.ModArmor;
import com.gamingsmod.telecomponents.common.reference.ArmorType;
import com.gamingsmod.telecomponents.common.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

public class ItemArmorTeleC extends ItemArmor {
    public ArmorMaterial amat;
    public int atype;
    public String itemTooltip;

    public ItemArmorTeleC(ArmorMaterial material, ArmorType type, String tooltip) {
        super(material, 0, type.getType());
        this.setCreativeTab(CreativeTabTeleC.TELEC_TAB);
        amat = material;
        atype = type.getType();
        itemTooltip = tooltip;
    }

    public ItemArmorTeleC(ArmorMaterial material, ArmorType type) {
        this(material, type, "");
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (itemStack.getItem().equals(ModArmor.teleIngotHelmet)) {
            if (!player.isPotionActive(Potion.nightVision) || player.getActivePotionEffect(Potion.nightVision).getDuration() < 210) {
                player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 300, 0, true, false));
            }
        }

        if (itemStack.getItem().equals(ModArmor.teleIngotLegs)) {
            if (!player.isPotionActive(Potion.moveSpeed) || player.getActivePotionEffect(Potion.moveSpeed).getDuration() < 210) {
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 300, 1, true, false));
            }
        }

        if (itemStack.getItem().equals(ModArmor.teleIngotBoots)) {
            if (!player.isPotionActive(Potion.jump) || player.getActivePotionEffect(Potion.jump).getDuration() < 210) {
                player.addPotionEffect(new PotionEffect(Potion.jump.id, 300, 1, true, false));
            }
        }

        if (    player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModArmor.teleIngotBoots) &&
                player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModArmor.teleIngotLegs) &&
                player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModArmor.teleIngotChest) &&
                player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModArmor.teleIngotHelmet))
            player.addPotionEffect(new PotionEffect(Potion.resistance.id, 50, 0, true, false));
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        return Reference.MOD_ID + ":textures/armor/" + this.amat + "_" + (this.atype == 2 ? "2" : "1") + ".png";
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        if (amat.toString().equals("teleingot")) {
            list.add("Get the protection of the gods");
        }

        if (!itemTooltip.equals("")) {
            list.add(itemTooltip);
        }
    }
}
