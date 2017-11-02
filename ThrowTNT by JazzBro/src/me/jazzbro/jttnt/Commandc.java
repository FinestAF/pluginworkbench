package me.jazzbro.jttnt;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Commandc implements CommandExecutor{
	
	public static String PREFIX = "§8[§b§lJThrowTNT§8] ";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		
		if(player.hasPermission("jtnt.comm")) {
		
		ItemStack swand = new ItemStack(Material.TNT);
		
		ItemMeta im = swand.getItemMeta();
		im.setDisplayName(ChatColor.YELLOW + "Throwing tnt");
		swand.setItemMeta(im);
		
		inv.addItem(swand);
		player.sendMessage(PREFIX + ChatColor.GOLD + "TnT added to inventory!");
		
	}
		else { player.sendMessage(PREFIX + ChatColor.DARK_RED + "You do not have permission to use this command!");
		}
		return false;
	}

}
