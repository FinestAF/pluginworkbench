package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jazzbro.specpvp.mainpack.Main;

public class Archere implements Listener{
	
	ArrayList<Player> archcooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack arrow = new ItemStack(Material.ARROW);
		
		ItemMeta aim = arrow.getItemMeta();
		aim.setDisplayName(ChatColor.LIGHT_PURPLE + "Barrage Arrow!");
		arrow.setItemMeta(aim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == arrow.getType()) {
				if(arrow.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Barrage Arrow!")) {
				if(archcooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 30 second cooldown!");
				}
				if (!(archcooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					event.getPlayer().launchProjectile(Arrow.class);
					player.sendMessage(ChatColor.AQUA + "Arrows fored!");
			    archcooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        archcooldown.remove(event.getPlayer());
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
