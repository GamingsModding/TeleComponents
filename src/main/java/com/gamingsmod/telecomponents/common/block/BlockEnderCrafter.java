package com.gamingsmod.telecomponents.common.block;

import com.gamingsmod.telecomponents.common.TeleComponents;
import com.gamingsmod.telecomponents.common.network.GuiHandler;
import com.gamingsmod.telecomponents.common.tileentity.TileEntityEnderCrafter;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockEnderCrafter extends BlockContainerTeleC
{
    public BlockEnderCrafter()
    {
        super();
        this.setUnlocalizedName("enderCrafter");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityEnderCrafter();
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        player.openGui(TeleComponents.instance, GuiHandler.MOD_ENDER_CRAFTING_ID, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public int getRenderType() {
        return 3;
    }
}
