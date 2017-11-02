package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.jazzbro.specpvp.mainpack.Main;

public class Peasante implements Listener{
	
	ArrayList<Player> pescooldown = new ArrayList<Player>();
	
	
		@EventHandler
		public void onPlayerInteract(PlayerInteractEvent event) {
			
			Player player = event.getPlayer();
			ItemStack bucket = new ItemStack(Material.BUCKET);
			ItemStack water = new ItemStack(Material.POTION);
			
			ItemMeta im = bucket.getItemMeta();
			im.setDisplayName(ChatColor.BLUE + "Fetch Water");
			bucket.setItemMeta(im);
			
			ItemMeta win = water.getItemMeta();
			win.setDisplayName(ChatColor.AQUA + "Holy water!");
			water.setItemMeta(win);
			
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if(player.getInventory().getItemInHand().getType() == bucket.getType()) {
					if(bucket.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.BLUE + "Fetch Water")) {
					if(pescooldown.contains(event.getPlayer())) {
						event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 30 second cooldown!");
					}
					if (!(pescooldown.contains(event.getPlayer()))) {
					event.setCancelled(true); {
				    player.sendMessage(ChatColor.AQUA + "You have fetched some water!");
				    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 120, 0));
				    player.getInventory().addItem(water, water, water);
				    player.playSound(player.getLocation(), Sound.SPLASH, 10, 1);
				    pescooldown.add(event.getPlayer());
				    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	                    public void run() {
	                        pescooldown.remove(event.getPlayer());
	                        event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "Your " + ChatColor.AQUA + "Ability " + ChatColor.GRAY + "is ready for use!" );
	                }
	                } , 600);
	        event.setCancelled(true);
					}
					}
					}
				}
				}
					
				
				
			}

}
