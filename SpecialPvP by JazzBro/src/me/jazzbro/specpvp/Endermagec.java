package me.jazzbro.specpvp;

import org.bukkit.ChatColor;
import org.bukkit.Color;
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
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;

import me.jazzbro.specpvp.mainpack.Main;

public class Endermagec implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		
		if(player.hasPermission("sp.endermage")) {
		
		inv.clear();
		for (PotionEffect effect : player.getActivePotionEffects())
	        player.removePotionEffect(effect.getType());
		
		ItemStack teleport = new ItemStack(Material.EYE_OF_ENDER);
		ItemStack diamondHoe = new ItemStack(Material.DIAMOND_HOE);
		ItemStack leatherHat = new ItemStack(Material.LEATHER_HELMET);
		ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leatherPants = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack leatherCreps = new ItemStack(Material.LEATHER_BOOTS);
		ItemStack water = new ItemStack(Material.POTION);
		
		
		ItemMeta im = teleport.getItemMeta();
		im.setDisplayName(ChatColor.DARK_PURPLE + "Blink");
		teleport.setItemMeta(im);
		
		ItemMeta bin = water.getItemMeta();
		bin.setDisplayName(ChatColor.AQUA + "Holy water!");
		water.setItemMeta(bin);
		
		ItemMeta sim = diamondHoe.getItemMeta();
		sim.setDisplayName("The End");
		diamondHoe.setItemMeta(sim);
		
		leatherHat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherPants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherCreps.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		
		leatherChest.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherCreps.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherPants.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherHat.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		diamondHoe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
		
		LeatherArmorMeta hatLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		hatLeatherArmorMeta.setColor(Color.fromRGB(51, 0, 102));
		leatherHat.setItemMeta(hatLeatherArmorMeta);
		
		LeatherArmorMeta chestLeatherArmorMeta = (LeatherArmorMeta) leatherChest.getItemMeta();
		chestLeatherArmorMeta.setColor(Color.fromRGB(51, 0, 102));
		leatherChest.setItemMeta(chestLeatherArmorMeta);
		
		LeatherArmorMeta pantsLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		pantsLeatherArmorMeta.setColor(Color.fromRGB(51, 0, 102));
		leatherPants.setItemMeta(pantsLeatherArmorMeta);
		
		LeatherArmorMeta crepsLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		crepsLeatherArmorMeta.setColor(Color.fromRGB(51, 0, 102));
		leatherCreps.setItemMeta(crepsLeatherArmorMeta);
		
		inv.addItem(diamondHoe, teleport, water, water, water, water, water, water);
		inv.setHelmet(leatherHat);
		inv.setChestplate(leatherChest);
		inv.setLeggings(leatherPants);
		inv.setBoots(leatherCreps);
		
		player.sendMessage(Main.PREFIX + ChatColor.DARK_AQUA + "Endermage kit selected");
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
		}
		else { 
			player.sendMessage(Main.PREFIX + ChatColor.RED + "You have not unlocked this kit!");
		}
		
		return false;
		
				
	}


	
	

}
