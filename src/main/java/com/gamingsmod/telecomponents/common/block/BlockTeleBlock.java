package com.gamingsmod.telecomponents.common.block;

import com.gamingsmod.telecomponents.common.TeleComponents;
import com.gamingsmod.telecomponents.common.helper.TeleportHelper;
import com.gamingsmod.telecomponents.common.item.ItemPortTeleport;
import com.gamingsmod.telecomponents.common.network.GuiHandler;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityTeleBlock;
import com.gamingsmod.telecomponents.common.utility.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.DimensionManager;

public class BlockTeleBlock extends BlockContainerTeleC
{
    public BlockTeleBlock() {
        super();
        this.setUnlocalizedName("teleBlock");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTeleBlock();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote) {
            ItemStack playerItem = player.getCurrentEquippedItem();

            if (playerItem != null) {
                if (playerItem.getItem() instanceof ItemPortTeleport) {
                    NBTHelper.setInteger(playerItem, "xCoord", pos.getX());
                    NBTHelper.setInteger(playerItem, "yCoord", pos.getY() + 1);
                    NBTHelper.setInteger(playerItem, "zCoord", pos.getZ());
                    return true;
                }
            }
            player.openGui(TeleComponents.instance, GuiHandler.MOD_TELE_BLOCK_ID, world, pos.getY(), pos.getY(), pos.getZ());
        }
        return true;
    }

    // Code copied from BlockChest because it is easier to copy the code as it is the same as every inventory
    // in the game
    // @source net.minecraft.block.BlockChest
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = worldIn.getTileEntity(pos);

        if (tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }


    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack)
    {
        if (stack.hasDisplayName()) {
            ((TileEntityTeleBlock) world.getTileEntity(pos)).setCustomName(stack.getDisplayName());
        }
        ((TileEntityTeleBlock) world.getTileEntity(pos)).setPlayerName(((EntityPlayer) player).getDisplayName().getFormattedText());
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        if (!world.isRemote && world.isBlockIndirectlyGettingPowered(pos) > 0)
        {
            EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getX(), pos.getX(), 5);
            if (player != null) {
                TileEntityTeleBlock te = (TileEntityTeleBlock) world.getTileEntity(pos);
                ItemStack item = te.getStackInSlot(0);
                if (item != null) {
                    int xCoord = NBTHelper.getInt(item, "xCoord");
                    int yCoord = NBTHelper.getInt(item, "yCoord");
                    int zCoord = NBTHelper.getInt(item, "zCoord");
                    int dimNum = NBTHelper.getInt(item, "dimNum");
                    World worldTo =  DimensionManager.getWorld(dimNum);

                    Block block1 = world.getBlockState(new BlockPos(xCoord, yCoord, zCoord)).getBlock();
                    Block block2 = world.getBlockState(new BlockPos(xCoord, yCoord + 1, zCoord)).getBlock();

                    if (yCoord > 0) {
                        if (!block1.isOpaqueCube() && !block2.isOpaqueCube()) {
                            if (worldTo.equals(world)) {
                                player.worldObj = worldTo;
                                player.setPositionAndUpdate(xCoord + .5, yCoord, zCoord + .5);
                            } else {
                                TeleportHelper.teleportEntityToDim(world, dimNum, xCoord + .5, yCoord, zCoord + .5, player);
                            }
                        }
                    }
                }
            }
        }
    }
}
