package com.gmail.rickvinke1.StireTweaks;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraftforge.common.FakePlayer;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class StireTweaksPlayerHandler implements IPlayerTracker {
	public boolean Stirecraft2;

	@Override
	public void onPlayerLogin(EntityPlayer entityplayer) {

		NBTTagCompound tags = entityplayer.getEntityData();
		if (!tags.hasKey("StireTweaks")) {
			tags.setCompoundTag("StireTweaks", new NBTTagCompound());
		}

		Stirecraft2 = tags.getCompoundTag("StireTweaks").getBoolean(
				"Stirecraft2");

		if (!Stirecraft2) {
			Stirecraft2 = true;
			tags.getCompoundTag("StireTweaks").setBoolean("Stirecraft2", true);
		}

	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
	}

}
