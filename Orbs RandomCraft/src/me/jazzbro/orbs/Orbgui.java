package me.jazzbro.orbs;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.milkbowl.vault.economy.Economy;

public class Orbgui implements Listener, CommandExecutor{
	
	public static Economy econ = null;
	public static String PREFIX = "§8[§b§lOrbs§8] ";
	
	public void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 27, ChatColor.AQUA + "Orb Center");
		
		ItemStack nop = new ItemStack(Material.STAINED_GLASS_PANE);
		nop.setDurability((short) 9);
		inv.setItem(0, nop);
		inv.setItem(1, nop);
		inv.setItem(2, nop);
		inv.setItem(3, nop);
		inv.setItem(4, nop);
		inv.setItem(5, nop);
		inv.setItem(6, nop);
		inv.setItem(7, nop);
		inv.setItem(8, nop);
		inv.setItem(9, nop);
		inv.setItem(17, nop);
		inv.setItem(18, nop);
		inv.setItem(19, nop);
		inv.setItem(20, nop);
		inv.setItem(21, nop);
		inv.setItem(22, nop);
		inv.setItem(23, nop);
		inv.setItem(24, nop);
		inv.setItem(25, nop);
		inv.setItem(26, nop);
		
		ItemStack fly = new ItemStack(Material.EYE_OF_ENDER);
		fly.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
		ItemMeta fim = fly.getItemMeta();
        fim.setDisplayName("§b§lFly");
        ArrayList<String> fLore = new ArrayList<String>();
        fLore.add(ChatColor.translateAlternateColorCodes('&', "&fPurchase access to fly"));
        fLore.add(ChatColor.translateAlternateColorCodes('&', "&fFor 1 day"));
        fLore.add(ChatColor.AQUA.toString());
        fLore.add(ChatColor.translateAlternateColorCodes('&', "&a&l$1,000,000"));
        fLore.add(ChatColor.AQUA.toString());
        fim.setLore(fLore);
        fly.setItemMeta(fim);
        inv.setItem(12, fly);
        
        ItemStack haste = new ItemStack(Material.EYE_OF_ENDER);
        haste.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1);
        ItemMeta him = haste.getItemMeta();
        him.setDisplayName("§c§lHaste");
        ArrayList<String> hLore = new ArrayList<String>();
        hLore.add(ChatColor.translateAlternateColorCodes('&', "&fPurchase Haste Buff"));
        hLore.add(ChatColor.translateAlternateColorCodes('&', "&fFor 6 Hours"));
        hLore.add(ChatColor.AQUA.toString());
        hLore.add(ChatColor.translateAlternateColorCodes('&', "&a&l$50,000"));
        hLore.add(ChatColor.AQUA.toString());
        him.setLore(hLore);
        haste.setItemMeta(him);
        inv.setItem(14, haste);
        
        player.openInventory(inv);
        
        
	}
	
	@EventHandler
    public void onClick(InventoryClickEvent event) {
    	if(event.getWhoClicked() instanceof Player) {
    
    	Player player = (Player)event.getWhoClicked();
    	ItemStack item = event.getCurrentItem(); 
    	if(event.getInventory().getTitle().equals(ChatColor.AQUA + "Orb Center")) {
            event.setCancelled(true);
    	if(item.hasItemMeta()) {
            if(event.getRawSlot() == 12) {
				player.performCommand("orbfly");
				player.closeInventory();
            } else if(event.getRawSlot() == 14) {
				player.performCommand("orbhaste");
				player.closeInventory();
            }
            }
    	}
    	}
	}
    	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
        if(commandLabel.equalsIgnoreCase("orbs") && args.length == 0){
            if(!(sender instanceof Player)){
                sender.sendMessage("This cannot be run from the console!");
                return true;
            }
            Player player = (Player) sender;
            player.sendMessage(PREFIX + ChatColor.DARK_AQUA + "You have open the orb center!");
            openGUI(player);
            return true;
        }
        return false;
    }
	
	
}
