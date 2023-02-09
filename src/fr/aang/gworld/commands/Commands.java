package fr.aang.gworld.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.aang.gworld.Main;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			
			if (sender.hasPermission("gworld.use")) {
				
				if (args[0].equals("reload")) {
					Main.getConf().reload();
					sender.sendMessage("§a[GWorld] Reload success");
					System.out.println("§a[GWorld] Reload success");
					return true;
				}
			}
		}
		else if (args[0].equals("reload")) {
			Main.getConf().reload();
			System.out.println("§a[GWorld] Reload success");
			return true;
		}
		return false;
	}
}
