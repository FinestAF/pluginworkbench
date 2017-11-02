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

public class Jammerc implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		
		Player player = (Player) sender;
		PlayerInventory inv = player.getInventory();
		
		if(player.hasPermission("sp.jammer")) {
		
		inv.clear();
		for (PotionEffect effect : player.getActivePotionEffects())
	        player.removePotionEffect(effect.getType());
		
		ItemStack stoneHoe = new ItemStack(Material.STONE_HOE);
		ItemStack stoneSword = new ItemStack(Material.STONE_SWORD);
		ItemStack leatherHat = new ItemStack(Material.LEATHER_HELMET);
		ItemStack leatherChest = new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack leatherPants = new ItemStack(Material.LEATHER_LEGGINGS);
		ItemStack leatherCreps = new ItemStack(Material.LEATHER_BOOTS);
		ItemStack water = new ItemStack(Material.POTION);
		
		
		ItemMeta im = stoneHoe.getItemMeta();
		im.setDisplayName(ChatColor.GRAY + "Cloak");
		stoneHoe.setItemMeta(im);
		
		ItemMeta bin = water.getItemMeta();
		bin.setDisplayName(ChatColor.AQUA + "Holy water!");
		water.setItemMeta(bin);
		
		ItemMeta sim = stoneSword.getItemMeta();
		sim.setDisplayName("Hidden Blade");
		stoneSword.setItemMeta(sim);
		
		stoneSword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		leatherHat.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherChest.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherPants.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		leatherCreps.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		
		stoneSword.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherChest.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherCreps.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherPants.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		leatherHat.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		LeatherArmorMeta hatLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		hatLeatherArmorMeta.setColor(Color.fromRGB(96, 96, 96));
		leatherHat.setItemMeta(hatLeatherArmorMeta);
		
		LeatherArmorMeta chestLeatherArmorMeta = (LeatherArmorMeta) leatherChest.getItemMeta();
		chestLeatherArmorMeta.setColor(Color.fromRGB(96, 96, 96));
		leatherPants.setItemMeta(chestLeatherArmorMeta);
		
		LeatherArmorMeta pantsLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		pantsLeatherArmorMeta.setColor(Color.fromRGB(96, 96, 96));
		leatherChest.setItemMeta(pantsLeatherArmorMeta);
		
		LeatherArmorMeta crepsLeatherArmorMeta = (LeatherArmorMeta) leatherHat.getItemMeta();
		crepsLeatherArmorMeta.setColor(Color.fromRGB(96, 96, 96));
		leatherCreps.setItemMeta(crepsLeatherArmorMeta);
		
		inv.addItem(stoneSword, stoneHoe, water, water, water, water, water, water);
		inv.setHelmet(leatherHat);
		inv.setChestplate(leatherChest);
		inv.setLeggings(leatherPants);
		inv.setBoots(leatherCreps);
		
		player.sendMessage(Main.PREFIX + ChatColor.DARK_AQUA + "Jammer kit selected");
		player.playSound(player.getLocation(), Sound.LEVEL_UP, 10, 1);
		}
		
		return false;
		
				
	}

}
