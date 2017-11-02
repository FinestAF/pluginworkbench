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

public class Ninjae implements Listener{
	
ArrayList<Player> nincooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack gnug = new ItemStack(Material.GOLD_NUGGET);
		
		ItemMeta nim = gnug.getItemMeta();
		nim.setDisplayName(ChatColor.YELLOW + "Fury");
		gnug.setItemMeta(nim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == gnug.getType()) {
				if(gnug.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Fury")) {
				if(nincooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 30 second cooldown!");
				}
				if (!(nincooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
					event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 1));
					event.getPlayer().sendMessage(ChatColor.AQUA + "You have released your fury");
					player.playSound(player.getLocation(), Sound.DONKEY_ANGRY, 10, 1);
			    nincooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        nincooldown.remove(event.getPlayer());
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
