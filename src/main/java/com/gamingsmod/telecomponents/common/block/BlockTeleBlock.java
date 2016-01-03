package com.gamingsmod.telecomponents.common.block;

import com.gamingsmod.telecomponents.common.TeleComponents;
import com.gamingsmod.telecomponents.common.network.GuiHandler;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import com.gamingsmod.telecomponents.common.utility.LogHelper;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.*;
import net.minecraft.command.server.CommandTeleport;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import java.util.List;
import java.util.Random;

public class BlockTeleBlock extends BlockContainerTeleC
{
    public BlockTeleBlock() {
        super();
        this.setBlockTextureName("teleBlock");
        this.setBlockName("teleBlock");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTeleBlock();
    }

    @Override
    public boolean onBlockActivated(World world, int blockx, int blocky, int blockz, EntityPlayer player, int face, float flt1, float flt2, float flt3)
    {
        if (!world.isRemote) {
            player.openGui(TeleComponents.instance, GuiHandler.MOD_TELE_BLOCK_ID, world, blockx, blocky, blockz);
        }
        return true;
    }

    // Code copied from BlockChest because it is easier to copy the code as it is the same as every inventory
    // in the game
    // @source net.minecraft.block.BlockChest
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        TileEntityTeleBlock te = (TileEntityTeleBlock) world.getTileEntity(x, y, z);
        Random random = new Random();

        if (te != null) {
            for (int i1 = 0; i1 < te.getSizeInventory(); ++i1) {
                ItemStack itemstack = te.getStackInSlot(i1);

                if (itemstack != null) {
                    float f = random.nextFloat() * 0.8F + 0.1F;
                    float f1 = random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem)) {
                        int j1 = random.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize) {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double) ((float) random.nextGaussian() * f3);
                        entityitem.motionY = (double) ((float) random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double) ((float) random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound()) {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, meta);
    }


    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
    {
        if (stack.hasDisplayName()) {
            ((TileEntityTeleBlock) world.getTileEntity(x, y, z)).setCustomName(stack.getDisplayName());
        }
        ((TileEntityTeleBlock) world.getTileEntity(x, y, z)).setPlayerName(((EntityPlayer) player).getDisplayName());
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(x, y, z))
        {
            EntityPlayer player = world.getClosestPlayer(x, y, z, 5);
            if (player != null) {
                TileEntityTeleBlock te = (TileEntityTeleBlock) world.getTileEntity(x, y, z);
                ItemStack item = te.getStackInSlot(0);
                if (item != null) {
                    int xCoord = NBTHelper.getInt(item, "xCoord");
                    int yCoord = NBTHelper.getInt(item, "yCoord");
                    int zCoord = NBTHelper.getInt(item, "zCoord");
                    Block block1 = world.getBlock(xCoord, yCoord, zCoord);
                    Block block2 = world.getBlock(xCoord, yCoord + 1, zCoord);

                    if (yCoord > 0) {
                        if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                            if ((!(block1 instanceof BlockStaticLiquid) && !(block2 instanceof BlockStaticLiquid))) {
                                player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                                LogHelper.info("The TeleBlock placed by " + te.getPlayerName() + " teleported " + player.getDisplayName() + " to " + xCoord + ", " + yCoord + ", " + zCoord);
                            } else {
                                logFailTeleport(te, player, xCoord, yCoord, zCoord, "fluid protection");
                            }
                        } else {
                            logFailTeleport(te, player, xCoord, yCoord, zCoord, "suffocation protection");
                        }
                    }
                }
            }
        }
    }

    private void logFailTeleport(TileEntityTeleBlock te, EntityPlayer player, int xCoord, int yCoord, int zCoord, String reason)
    {
        LogHelper.info("The TeleBlock placed by " + te.getPlayerName() + " failed to teleport " + player.getDisplayName() + " to " + xCoord + ", " + yCoord + ", " + zCoord + " because " + reason);
    }
}
