package me.jazzbro.specpvp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class Peasantc implements CommandExecutor{
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		
		inv.clear();
		for (PotionEffect effect : player.getActivePotionEffects())
	        player.removePotionEffect(effect.getType());
		
		ItemStack bucket = new ItemStack(Material.BUCKET);
		ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
		ItemStack leatherHat = new ItemStack(Material.LEATHER_HELMET);
		ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leatherPants = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack leatherCreps = new ItemStack(Material.LEATHER_BOOTS);
		ItemStack water = new ItemStack(Material.POTION);
		
		
		ItemMeta im = bucket.getItemMeta();
		im.setDisplayName(ChatColor.BLUE + "Fetch Water");
		bucket.setItemMeta(im);
		
		ItemMeta bin = water.getItemMeta();
		bin.setDisplayName(ChatColor.AQUA + "Holy water!");
		water.setItemMeta(bin);
		
		ItemMeta sim = stoneSword.getItemMeta();
		sim.setDisplayName("Pocket knife");
		stoneSword.setItemMeta(sim);
		
		leatherHat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherPants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherCreps.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		
		stoneSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherChest.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherCreps.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherPants.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherHat.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		inv.addItem(stoneSword, bucket, water, water, water, water, water, water);
		inv.setHelmet(leatherHat);
		inv.setChestplate(leatherChest);
		inv.setLeggings(leatherPants);
		inv.setBoots(leatherCreps);
		
		player.sendMessage("§6[§2§lP§6-§2§lN§6] " + ChatColor.DARK_AQUA + "Peasant kit selected");
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
		
		
		return false;
	}

}
