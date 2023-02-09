package fr.aang.gworld;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.boss.DragonBattle;
import org.bukkit.entity.EntityType;

public class WorldManager {

	public static void setBorderSize(World world, int border_size) {
		
		WorldBorder border = world.getWorldBorder();
		
		border.setCenter(0, 0);
		border.setDamageAmount(5);
		border.setDamageBuffer(10);
		border.setWarningDistance(20);
		border.setSize(border_size);
	}
	
	public static void respawnEnderDragon() {
		
		World world = Bukkit.getWorld("world_the_end");
		world.getBlockAt(0,65,0).setType(Material.DRAGON_EGG);
		world.spawnEntity(world.getBlockAt(0,62,3).getLocation(), EntityType.ENDER_CRYSTAL);
		world.spawnEntity(world.getBlockAt(0,62,-3).getLocation(), EntityType.ENDER_CRYSTAL);
		world.spawnEntity(world.getBlockAt(3,62,0).getLocation(), EntityType.ENDER_CRYSTAL);
		world.spawnEntity(world.getBlockAt(-3,62,0).getLocation(), EntityType.ENDER_CRYSTAL);
		DragonBattle db = world.getEnderDragonBattle();
		db.initiateRespawn();
	}
}
