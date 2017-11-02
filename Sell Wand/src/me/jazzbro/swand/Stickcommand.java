package me.jazzbro.swand;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class Stickcommand implements CommandExecutor{
	
	public static String PREFIX = "§8[§b§lJSellWand§8] ";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		
		ItemStack swand = new ItemStack(Material.STICK);
		
		ItemMeta im = swand.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Sell Wand");
		swand.setItemMeta(im);
		
		inv.addItem(swand);
		player.sendMessage(PREFIX + ChatColor.GOLD + "Wand added to inventory!");
		return false;
	}

}
