package fr.aang.gworld.config;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.aang.gworld.Main;
import fr.aang.gworld.WorldManager;

public class Config {

	private String				_file_name;
	private File				_file;
	private YamlConfiguration	_yaml;

	public Config(String file_name) {
		_file_name = file_name;
		_yaml = loadConfig(file_name);
		readConfig();
	}
	
	private YamlConfiguration loadConfig(String file_name) {
		
		if(!Main.getInstance().getDirectory().exists()) {
			Main.getInstance().getDirectory().mkdir();
		}
		
		_file = new File(Main.getInstance().getDataFolder(), file_name);
		
		if (!_file.exists()) {
			Main.getInstance().saveResource(file_name, false);
		}
		
		return YamlConfiguration.loadConfiguration(_file);
	}
	
	private void	readConfig() {
		
		ConfigurationSection section;
		
		int i = 0;
		while ((section = _yaml.getConfigurationSection("worlds." + i)) != null) {
			
			if (section.isSet("border")) {
				World world = Bukkit.getWorld(section.getString("name"));
				WorldManager.setBorderSize(world, section.getInt("border"));
			}
			i++;
		}
	}
	
	public void reload() {
		_yaml = loadConfig(_file_name);
		readConfig();
	}
}
