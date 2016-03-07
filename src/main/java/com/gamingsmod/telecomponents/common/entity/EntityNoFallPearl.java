package com.gamingsmod.telecomponents.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


// Code adapted from EntityEnderPearl
public class EntityNoFallPearl extends EntityThrowable
{
    private EntityLivingBase entity;

    public EntityNoFallPearl(World world)
    {
        super(world);
    }

    public EntityNoFallPearl(World world, EntityLivingBase entity)
    {
        super(world, entity);
        this.entity = entity;
    }

    @SideOnly(Side.CLIENT)
    public EntityNoFallPearl(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition pos)
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (pos.entityHit != null)
        {
            if (pos.entityHit == this.entity)
            {
                return;
            }
        }

        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.PORTAL, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            if (entitylivingbase instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)entitylivingbase;

                if (entityplayermp.playerNetServerHandler.getNetworkManager().isChannelOpen() && entityplayermp.worldObj == this.worldObj && !entityplayermp.isPlayerSleeping())
                {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 0.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size
                        if (entitylivingbase.isRiding())
                        {
                            entitylivingbase.mountEntity((Entity)null);
                        }

                        entitylivingbase.setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        entitylivingbase.fallDistance = 0.0F;
                        entitylivingbase.attackEntityFrom(DamageSource.fall, event.attackDamage);
                    }
                }
            }
            else if (entitylivingbase != null)
            {
                entitylivingbase.setPositionAndUpdate(this.posX, this.posY, this.posZ);
                entitylivingbase.fallDistance = 0.0F;
            }

            this.setDead();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();
        }
    }
}
