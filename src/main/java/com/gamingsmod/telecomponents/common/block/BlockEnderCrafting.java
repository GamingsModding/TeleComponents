package com.gamingsmod.telecomponents.common.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnderCrafting extends BlockContainerTeleC
{
    public BlockEnderCrafting() {
        super();
        this.setUnlocalizedName("enderCrafting");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }

    @Override
    public int getRenderType() {
        return 3;
    }
}
