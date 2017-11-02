package me.jazzbro.specpvp.kitsels;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jazzbro.specpvp.mainpack.Main;

public class Buyselector implements Listener{
	
	public void openGUI(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Kit Shop");
		ItemStack archer = new ItemStack(Material.BOW);
		ItemMeta archmeta = archer.getItemMeta();
		archmeta.setDisplayName("§6Archer");
		ArrayList<String> aLore = new ArrayList<String>();
		aLore.add(ChatColor.AQUA.toString());
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&3Use your bow to"));
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&3elimate your target."));
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&3Your special will"));
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&3fire a barrage of"));
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&3arrows."));
        aLore.add(ChatColor.AQUA.toString());
        aLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $150"));
        aLore.add(ChatColor.AQUA.toString());
        archmeta.setLore(aLore);
      	archer.setItemMeta(archmeta);
		
		ItemStack blaze = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta blameta = blaze.getItemMeta();
		blameta.setDisplayName("§6Blaze");
		ArrayList<String> bLore = new ArrayList<String>();
		bLore.add(ChatColor.AQUA.toString());
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are immune to fire,"));
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&3light your enemies"));
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&3with your flamed sword."));
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&3Use your ability to"));
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&3spit super hot fire!"));
        bLore.add(ChatColor.AQUA.toString());
        bLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        bLore.add(ChatColor.AQUA.toString());
        blameta.setLore(bLore);
        blaze.setItemMeta(blameta);
		
		ItemStack blood = new ItemStack(Material.REDSTONE);
		ItemMeta blometa = blood.getItemMeta();
		blometa.setDisplayName("§6BloodMage");
		ArrayList<String> blLore = new ArrayList<String>();
		blLore.add(ChatColor.AQUA.toString());
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the sucker"));
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3drain the blood from your"));
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3enemy so you can"));
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3be fed. Your ability"));
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3lets you feast upon the"));
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&3health of your target."));
        blLore.add(ChatColor.AQUA.toString());
        blLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $800"));
        blLore.add(ChatColor.AQUA.toString());
        blometa.setLore(blLore);
		blood.setItemMeta(blometa);
		
		ItemStack endm = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta endmeta = endm.getItemMeta();
		endmeta.setDisplayName("§6EndMage");
		ArrayList<String> eLore = new ArrayList<String>();
	    eLore.add(ChatColor.AQUA.toString());
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&3You have the powers"));
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&3of an enderman"));
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your ability to"));
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&3blink forward"));
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&3catching your enemy by suprise."));
        eLore.add(ChatColor.AQUA.toString());
        eLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        eLore.add(ChatColor.AQUA.toString());
        endmeta.setLore(eLore);
    	    endm.setItemMeta(endmeta);
		
		ItemStack jammer = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
		ItemMeta jameta = jammer.getItemMeta();
		jameta.setDisplayName("§6Jammer");
		ArrayList<String> jLore = new ArrayList<String>();
		jLore.add(ChatColor.AQUA.toString());
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&3You're the coward"));
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your cloak ability"));
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&3to cover yourself"));
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&3giving you an extra layer"));
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&3of armour."));
        jLore.add(ChatColor.AQUA.toString());
        jLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        jLore.add(ChatColor.AQUA.toString());
        jameta.setLore(jLore);
        jammer.setItemMeta(jameta);
		
		ItemStack ninja = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta ninmeta = ninja.getItemMeta();
		ninmeta.setDisplayName("§6Ninja");
		ArrayList<String> nLore = new ArrayList<String>();
		nLore.add(ChatColor.AQUA.toString());
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the ninja!"));
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3you have a speed boost"));
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3to ensure you can run away"));
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3quick enough. Your ability"));
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3helps you to chop down"));
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&3your enemy."));
        nLore.add(ChatColor.AQUA.toString());
        nLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        nLore.add(ChatColor.AQUA.toString());
        ninmeta.setLore(nLore);
        ninja.setItemMeta(ninmeta);
		
		ItemStack peas = new ItemStack(Material.WATER_BUCKET);
		ItemMeta pesmeta = peas.getItemMeta();
		peas.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		pesmeta.setDisplayName("§6Peasant");
		ArrayList<String> pLore = new ArrayList<String>();
		pLore.add(ChatColor.AQUA.toString());
        pLore.add(ChatColor.translateAlternateColorCodes('&', "&3You're a peaant"));
        pLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your ability"));
        pLore.add(ChatColor.translateAlternateColorCodes('&', "&3to gather more water bottles"));
        pLore.add(ChatColor.translateAlternateColorCodes('&', "&3to aid you in battle."));
        pLore.add(ChatColor.AQUA.toString());
        pLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        pLore.add(ChatColor.AQUA.toString());
        pesmeta.setLore(pLore);
        peas.setItemMeta(pesmeta);
		
		ItemStack snow = new ItemStack(Material.SNOW_BALL);
		ItemMeta snometa = snow.getItemMeta();
		snometa.setDisplayName("§6SnowMan");
		ArrayList<String> sLore = new ArrayList<String>();
		sLore.add(ChatColor.AQUA.toString());
        sLore.add(ChatColor.translateAlternateColorCodes('&', "&3You made winter cold."));
        sLore.add(ChatColor.translateAlternateColorCodes('&', "&3Use your ability"));
        sLore.add(ChatColor.translateAlternateColorCodes('&', "&3to freeze your enemy"));
        sLore.add(ChatColor.translateAlternateColorCodes('&', "&3with the harsh blizzard."));
        sLore.add(ChatColor.AQUA.toString());
        sLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        sLore.add(ChatColor.AQUA.toString());
        snometa.setLore(sLore);
        snow.setItemMeta(snometa);
		
		ItemStack warrior = new ItemStack(Material.STONE_SWORD);
		ItemMeta wameta = warrior.getItemMeta();
		wameta.setDisplayName("§6Warrior");
		ArrayList<String> wLore = new ArrayList<String>();
		wLore.add(ChatColor.AQUA.toString());
        wLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the blade"));
        wLore.add(ChatColor.translateAlternateColorCodes('&', "&3your ability makes you"));
        wLore.add(ChatColor.translateAlternateColorCodes('&', "&3savage as you gain more"));
        wLore.add(ChatColor.translateAlternateColorCodes('&', "&3strength."));
        wLore.add(ChatColor.AQUA.toString());
        wLore.add(ChatColor.translateAlternateColorCodes('&', "&6Purchase for $500"));
        wLore.add(ChatColor.AQUA.toString());
        wameta.setLore(wLore);
        warrior.setItemMeta(wameta);
		
		// 
        // BOUGHT KITS
        //
        
        ItemStack barcher = new ItemStack(Material.BOW);
		ItemMeta barchmeta = archer.getItemMeta();
		barcher.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		barchmeta.setDisplayName("§6Archer");
		ArrayList<String> baLore = new ArrayList<String>();
		baLore.add(ChatColor.AQUA.toString());
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&3Use your bow to"));
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&3elimate your target."));
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&3Your special will"));
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&3fire a barrage of"));
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&3arrows."));
        baLore.add(ChatColor.AQUA.toString());
        baLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        baLore.add(ChatColor.AQUA.toString());
        barchmeta.setLore(baLore);
        barcher.setItemMeta(barchmeta);
		
		ItemStack bblaze = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta bblameta = bblaze.getItemMeta();
		bblaze.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bblameta.setDisplayName("§6Blaze");
		ArrayList<String> bbLore = new ArrayList<String>();
		bbLore.add(ChatColor.AQUA.toString());
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are immune to fire,"));
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&3light your enemies"));
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&3with your flamed sword."));
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&3Use your ability to"));
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&3spit super hot fire!"));
        bbLore.add(ChatColor.AQUA.toString());
        bbLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bbLore.add(ChatColor.AQUA.toString());
        bblameta.setLore(bbLore);
        bblaze.setItemMeta(bblameta);
		
		ItemStack bblood = new ItemStack(Material.REDSTONE);
		ItemMeta bblometa = bblood.getItemMeta();
		bblood.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bblometa.setDisplayName("§6BloodMage");
		ArrayList<String> bblLore = new ArrayList<String>();
		bblLore.add(ChatColor.AQUA.toString());
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the sucker"));
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3drain the blood from your"));
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3enemy so you can"));
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3be fed. Your ability"));
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3lets you feast upon the"));
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&3health of your target."));
        bblLore.add(ChatColor.AQUA.toString());
        bblLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bblLore.add(ChatColor.AQUA.toString());
        bblometa.setLore(bblLore);
        bblood.setItemMeta(bblometa);
		
		ItemStack bendm = new ItemStack(Material.EYE_OF_ENDER);
		ItemMeta bendmeta = bendm.getItemMeta();
		bendm.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bendmeta.setDisplayName("§6EndMage");
		ArrayList<String> beLore = new ArrayList<String>();
		beLore.add(ChatColor.AQUA.toString());
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&3You have the powers"));
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&3of an enderman"));
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your ability to"));
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&3blink forward"));
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&3catching your enemy by suprise."));
        beLore.add(ChatColor.AQUA.toString());
        beLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        beLore.add(ChatColor.AQUA.toString());
        bendmeta.setLore(beLore);
        bendm.setItemMeta(bendmeta);
		
		ItemStack bjammer = new ItemStack(Material.DARK_OAK_DOOR_ITEM);
		ItemMeta bjameta = bjammer.getItemMeta();
		bjammer.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bjameta.setDisplayName("§6Jammer");
		ArrayList<String> bjLore = new ArrayList<String>();
		bjLore.add(ChatColor.AQUA.toString());
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&3You're the coward"));
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your cloak ability"));
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&3to cover yourself"));
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&3giving you an extra layer"));
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&3of armour."));
        bjLore.add(ChatColor.AQUA.toString());
        bjLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bjLore.add(ChatColor.AQUA.toString());
        bjameta.setLore(bjLore);
        bjammer.setItemMeta(bjameta);
		
		ItemStack bninja = new ItemStack(Material.GOLD_BOOTS);
		ItemMeta bninmeta = bninja.getItemMeta();
		bninja.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bninmeta.setDisplayName("§6Ninja");
		ArrayList<String> bnLore = new ArrayList<String>();
		bnLore.add(ChatColor.AQUA.toString());
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the ninja!"));
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3you have a speed boost"));
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3to ensure you can run away"));
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3quick enough. Your ability"));
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3helps you to chop down"));
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&3your enemy."));
        bnLore.add(ChatColor.AQUA.toString());
        bnLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bnLore.add(ChatColor.AQUA.toString());
        bninmeta.setLore(bnLore);
        bninja.setItemMeta(bninmeta);
		
		ItemStack bsnow = new ItemStack(Material.SNOW_BALL);
		ItemMeta bsnometa = bsnow.getItemMeta();
		bsnow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bsnometa.setDisplayName("§6SnowMan");
		ArrayList<String> bsLore = new ArrayList<String>();
		bsLore.add(ChatColor.AQUA.toString());
        bsLore.add(ChatColor.translateAlternateColorCodes('&', "&3You made winter cold"));
        bsLore.add(ChatColor.translateAlternateColorCodes('&', "&3use your ability"));
        bsLore.add(ChatColor.translateAlternateColorCodes('&', "&3to freeze your enemy"));
        bsLore.add(ChatColor.translateAlternateColorCodes('&', "&3with the harsh blizzard."));
        bsLore.add(ChatColor.AQUA.toString());
        bsLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bsLore.add(ChatColor.AQUA.toString());
        bsnometa.setLore(bsLore);
        bsnow.setItemMeta(bsnometa);
		
		ItemStack bwarrior = new ItemStack(Material.STONE_SWORD);
		ItemMeta bwameta = bwarrior.getItemMeta();
		bwarrior.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1);
		bwameta.setDisplayName("§6Warrior");
		ArrayList<String> bwLore = new ArrayList<String>();
		bwLore.add(ChatColor.AQUA.toString());
        bwLore.add(ChatColor.translateAlternateColorCodes('&', "&3You are the blade"));
        bwLore.add(ChatColor.translateAlternateColorCodes('&', "&3your ability makes you"));
        bwLore.add(ChatColor.translateAlternateColorCodes('&', "&3savage as you gain more"));
        bwLore.add(ChatColor.translateAlternateColorCodes('&', "&3strength."));
        bwLore.add(ChatColor.AQUA.toString());
        bwLore.add(ChatColor.translateAlternateColorCodes('&', "&aUNLOCKED"));
        bwLore.add(ChatColor.AQUA.toString());
        bwameta.setLore(bwLore);
    	    bwarrior.setItemMeta(bwameta);
		
		inv.setItem(0, peas);
		
        if(!(player.hasPermission("sp.archer"))) {
        inv.setItem(1, archer);
		}
		else { 
			inv.setItem(1, barcher);
		}
		if(!(player.hasPermission("sp.blaze"))) {
	        inv.setItem(2, blaze);
			}
			else { 
				inv.setItem(2, bblaze);
			}
		if(!(player.hasPermission("sp.bloodmage"))) {
	        inv.setItem(3, blood);
			}
			else { 
				inv.setItem(3, bblood);
			}
		if(!(player.hasPermission("sp.endmage"))) {
	        inv.setItem(4, endm);
			}
			else { 
				inv.setItem(4, bendm);
			}
		if(!(player.hasPermission("sp.jammer"))) {
	        inv.setItem(5, jammer);
			}
			else { 
				inv.setItem(5, bjammer);
			}
		if(!(player.hasPermission("sp.ninja"))) {
	        inv.setItem(6, ninja);
			}
			else { 
				inv.setItem(6, bninja);
			}
		if(!(player.hasPermission("sp.snowman"))) {
	        inv.setItem(7, snow);
			}
			else { 
				inv.setItem(7, bsnow);
			}
		if(!(player.hasPermission("sp.warrior"))) {
	        inv.setItem(8, warrior);
			}
			else { 
				inv.setItem(8, bwarrior);
			}
		
		player.openInventory(inv);
		
	}
		
		@EventHandler
	    public void onClick(InventoryClickEvent event) {
	    	if(event.getWhoClicked() instanceof Player) {
	    
	    	Player player = (Player)event.getWhoClicked();
	    	
	    	ItemStack item = event.getCurrentItem(); 
	    	
	    	if(event.getInventory().getTitle().equals(ChatColor.AQUA + "Kit Shop")) {
	    		event.setCancelled(true);
	    	if(item.hasItemMeta()) {
	            if(event.getRawSlot() == 1) {
					player.performCommand("barcher");
					player.closeInventory();
	            } else if(event.getRawSlot() == 2) {
					player.performCommand("bblaze");
					player.closeInventory();
	            } else if(event.getRawSlot() == 3) {
					player.performCommand("bbloodmage");
					player.closeInventory();
	            } else if(event.getRawSlot() == 4) {
					player.performCommand("bendmage");
					player.closeInventory();
	            } else if(event.getRawSlot() == 5) {
					player.performCommand("bjammer");
					player.closeInventory();
	            } else if(event.getRawSlot() == 6) {
					player.performCommand("bninja");
					player.closeInventory();
	            } else if(event.getRawSlot() == 0) {
					player.performCommand("bpeasant");
					player.closeInventory();
	            } else if(event.getRawSlot() == 7) {
					player.performCommand("bsnowman");
					player.closeInventory();
	            } else if(event.getRawSlot() == 8) {
					player.performCommand("bwarrior");
					player.closeInventory();
	            }
	            
	
	            }
	    	}
	    	}

}

	    	
	    	@EventHandler
		    public void onPunch(PlayerInteractEvent event) {
		        Player player = event.getPlayer();
		        
		        ItemStack kitsel = new ItemStack(Material.DIAMOND);
		        ItemMeta kim = kitsel.getItemMeta();
				kim.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lKit Shop"));
				kitsel.setItemMeta(kim);
				
		        if(player.getItemInHand().equals(kitsel)) {
		        	if(kitsel.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&b&lKit Shop"))) {
		            openGUI(player);
		            player.playSound(player.getLocation(), Sound.CHEST_OPEN, 10, 1);
		            player.sendMessage(Main.PREFIX + ChatColor.DARK_AQUA + "Kit Shop opened!");
		        }
		        }
	    	}

}
