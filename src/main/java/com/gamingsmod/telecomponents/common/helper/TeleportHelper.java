package com.gamingsmod.telecomponents.common.helper;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.Iterator;

public class TeleportHelper
{
    // Adapted from Blood Magic
    // @source https://github.com/WayofTime/BloodMagic/blob/277cd0742e1e19eae3ffc9a7a56e789a4a8826a6/src/main/java/WayofTime/alchemicalWizardry/common/spell/complex/effect/SpellHelper.java
    public static Entity teleportEntityToDim(World prevWorld, int newWorldID, double d, double e, double f, Entity entity)
    {
        if (entity != null)
        {
            if (entity.timeUntilPortal <= 0)
            {
                WorldServer oldWorldServer = MinecraftServer.getServer().worldServerForDimension(entity.dimension);
                WorldServer newWorldServer = MinecraftServer.getServer().worldServerForDimension(newWorldID);
                if (entity instanceof EntityPlayer)
                {
                    EntityPlayerMP player = (EntityPlayerMP) entity;
                    if (!player.worldObj.isRemote)
                    {
                        player.worldObj.theProfiler.startSection("portal");
                        player.worldObj.theProfiler.startSection("changeDimension");
                        ServerConfigurationManager config = player.mcServer.getConfigurationManager();
                        prevWorld.playSoundEffect(player.posX, player.posY, player.posZ, "mob.endermen.portal", 1.0F, 1.0F);
                        player.closeScreen();
                        player.dimension = newWorldServer.provider.getDimensionId();
                        player.playerNetServerHandler.sendPacket(new S07PacketRespawn(player.dimension, player.worldObj.getDifficulty(), newWorldServer.getWorldInfo().getTerrainType(), player.theItemInWorldManager.getGameType()));
                        oldWorldServer.removeEntity(player);
                        player.isDead = false;
                        player.setLocationAndAngles(d, e, f, player.rotationYaw, player.rotationPitch);
                        newWorldServer.spawnEntityInWorld(player);
                        player.setWorld(newWorldServer);
                        config.preparePlayer(player, oldWorldServer);
                        player.playerNetServerHandler.setPlayerLocation(d, e, f, entity.rotationYaw, entity.rotationPitch);
                        player.theItemInWorldManager.setWorld(newWorldServer);
                        config.updateTimeAndWeatherForPlayer(player, newWorldServer);
                        config.syncPlayerInventory(player);
                        player.worldObj.theProfiler.endSection();
                        oldWorldServer.resetUpdateEntityTick();
                        newWorldServer.resetUpdateEntityTick();
                        player.worldObj.theProfiler.endSection();
                        for (Iterator<PotionEffect> potion = player.getActivePotionEffects().iterator(); potion.hasNext();)
                        {
                            player.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(player.getEntityId(), potion.next()));
                        }
                        player.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(player.experience, player.experienceTotal, player.experienceLevel));
                        FMLCommonHandler.instance().firePlayerChangedDimensionEvent(player, oldWorldServer.provider.getDimensionId(), player.dimension);
                        player.timeUntilPortal = 150;
                    }
                    player.worldObj.theProfiler.endSection();
                    newWorldServer.playSoundEffect(d, e, f, "mob.endermen.portal", 1.0F, 1.0F);
                    return player;
                } else
                {
                    NBTTagCompound tag = new NBTTagCompound();
                    entity.writeToNBTOptional(tag);
                    entity.setDead();
                    prevWorld.playSoundEffect(entity.posX, entity.posY, entity.posZ, "mob.endermen.portal", 1.0F, 1.0F);
                    Entity teleportedEntity = EntityList.createEntityFromNBT(tag, newWorldServer);
                    if (teleportedEntity != null)
                    {
                        teleportedEntity.setLocationAndAngles(d, e, f, entity.rotationYaw, entity.rotationPitch);
                        teleportedEntity.forceSpawn = true;
                        newWorldServer.spawnEntityInWorld(teleportedEntity);
                        teleportedEntity.setWorld(newWorldServer);
                        teleportedEntity.timeUntilPortal = 150;
                    }
                    oldWorldServer.resetUpdateEntityTick();
                    newWorldServer.resetUpdateEntityTick();
                    newWorldServer.playSoundEffect(d, e, f, "mob.endermen.portal", 1.0F, 1.0F);
                    return teleportedEntity;
                }
            }
        }
        return null;
    }
}
