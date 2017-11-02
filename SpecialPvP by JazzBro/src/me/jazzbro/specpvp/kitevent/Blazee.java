package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jazzbro.specpvp.mainpack.Main;

public class Blazee implements Listener{
	
ArrayList<Player> blazecooldown = new ArrayList<Player>();
	
    @EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
		
		ItemMeta jim = blaze.getItemMeta();
		jim.setDisplayName(ChatColor.YELLOW + "Firestorm");
		blaze.setItemMeta(jim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == blaze.getType()) {
				if(blaze.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Firestorm")) {
				if(blazecooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 20 second cooldown!");
				}
				if (!(blazecooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    event.getPlayer().sendMessage(ChatColor.AQUA + "You spat super hot fire");
			    event.getPlayer().launchProjectile(SmallFireball.class);
			    event.getPlayer().launchProjectile(SmallFireball.class);
			    event.getPlayer().launchProjectile(SmallFireball.class);
			    player.playSound(player.getLocation(), Sound.BLAZE_BREATH, 10, 1);
			    blazecooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        blazecooldown.remove(event.getPlayer());
                        event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "Your " + ChatColor.AQUA + "Ability " + ChatColor.GRAY + "is ready for use!" );
                }
                } , 400);
        event.setCancelled(true);
        
				
				}
				}
			}
		}
	}
}


}
