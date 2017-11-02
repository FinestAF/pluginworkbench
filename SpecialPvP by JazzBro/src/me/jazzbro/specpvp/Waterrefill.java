package me.jazzbro.specpvp;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.jazzbro.specpvp.mainpack.Main;

public class Waterrefill implements CommandExecutor{
	
	ArrayList<Player> refillc = new ArrayList<Player>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		ItemStack water = new ItemStack(Material.POTION);
		
		ItemMeta bin = water.getItemMeta();
		bin.setDisplayName(ChatColor.AQUA + "Holy water!");
		water.setItemMeta(bin);
		
		if(refillc.contains(player)) {
			player.sendMessage(Main.PREFIX + ChatColor.GRAY + "You can only refill once every 5 minutes!");
		}
		
		if(Main.econ.withdrawPlayer(player, 8).transactionSuccess()) {
			if(!(refillc.contains(player))) {
				inv.addItem(water, water, water);
				player.sendMessage(Main.PREFIX + ChatColor.GREEN + "You have receieved a refill!");
				  refillc.add(player);
				    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	                    public void run() {
	                        refillc.remove(player);
	                        
	                }
	                } , 6000);
			}
		}
		else { 
			player.sendMessage(Main.PREFIX + ChatColor.RED + "You do not have enough money");
		}
		return false;
	}
}
