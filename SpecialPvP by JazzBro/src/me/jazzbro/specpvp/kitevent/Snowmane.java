package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.jazzbro.specpvp.mainpack.Main;

public class Snowmane implements Listener{
	
	ArrayList<Player> snowcooldown = new ArrayList<Player>();
	
	@EventHandler
	public void EntityDamageByEntity(EntityDamageByEntityEvent event) {
		
		Player damager = (Player) event.getDamager();
		
		if(event.getCause() == DamageCause.PROJECTILE) {
	            if(event.getDamager() instanceof Snowball) {
	                if(event.getEntity() instanceof Player) {
	                	
	                	ItemStack carrot = new ItemStack(Material.GOLDEN_CARROT);
	            		
	            		ItemMeta jim = carrot.getItemMeta();
	            		jim.setDisplayName(ChatColor.WHITE + "Blizzard");
	            		carrot.setItemMeta(jim);

	                	if(damager.getInventory().contains(carrot)) {
	                		if(carrot.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Blizzard")) {
	                			Player target = (Player) event.getEntity(); 
	                			event.setDamage(4);
	                			target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 80, 3));
	                }
	                	}
	                }
	                }
	            }
		 }
	
    @EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack carrot = new ItemStack(Material.GOLDEN_CARROT);
		
		ItemMeta jim = carrot.getItemMeta();
		jim.setDisplayName(ChatColor.WHITE + "Blizzard");
		carrot.setItemMeta(jim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == carrot.getType()) {
				if(carrot.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.WHITE + "Blizzard")) {
				if(snowcooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 15 second cooldown!");
				}
				if (!(snowcooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    event.getPlayer().sendMessage(ChatColor.AQUA + "You sent a Blizzard!");
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    event.getPlayer().launchProjectile(Snowball.class);
			    snowcooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        snowcooldown.remove(event.getPlayer());
                        event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "Your " + ChatColor.AQUA + "Ability " + ChatColor.GRAY + "is ready for use!" );
                }
                } , 300);
        event.setCancelled(true);
        
				
				}
				}
			}
		}
	}
}

}
