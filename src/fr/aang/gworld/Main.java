package fr.aang.gworld;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import fr.aang.gworld.commands.Commands;
import fr.aang.gworld.config.Config;


public class Main extends JavaPlugin {

	private static Main		_instance;
	private static Config 	_config;
	
	@Override
	public void onEnable() {
		
		_instance = this;
		_config = new Config("config.yml");
		getCommand("monde").setExecutor(new Commands());
		
	}
	
	public static Main getInstance() {
		return _instance;
	}
	
	public static Config getConf() {
		return _config;
	}
	
	public File getDirectory() {
		return getDataFolder();
	}
}
