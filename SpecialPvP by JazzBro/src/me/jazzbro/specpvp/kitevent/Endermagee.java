package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.jazzbro.specpvp.mainpack.Main;

public class Endermagee implements Listener{
	
	private Random rand;
	protected void setUp()
	{
		rand = new Random();
	}
	
	ArrayList<Player> endcooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack teleport = new ItemStack(Material.EYE_OF_ENDER);
		Location loc = player.getLocation();
		Vector dir = loc.getDirection();
		
		ItemMeta jim = teleport.getItemMeta();
		jim.setDisplayName(ChatColor.DARK_PURPLE + "Blink");
		teleport.setItemMeta(jim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == teleport.getType()) {
				if(teleport.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "Blink")) {
				if(endcooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 10 second cooldown!");
				}
				if (!(endcooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    event.getPlayer().sendMessage(ChatColor.AQUA + "You just blinked");
			    dir.normalize();
			    dir.multiply(12);
			    loc.add(dir);
			    player.teleport(loc);
			    player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			    endcooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        endcooldown.remove(event.getPlayer());
                        event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "Your " + ChatColor.AQUA + "Ability " + ChatColor.GRAY + "is ready for use!" );
                }
                } , 200);
        event.setCancelled(true);
        
				
				}
		        
			}
		}
			ItemStack i = event.getItem();
	
			if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
				if(i.getType() == (Material.EYE_OF_ENDER)) {
					event.setCancelled(true);
				}
			}
			}
	}
		ItemStack i = event.getItem();
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(i.getType() == (Material.EYE_OF_ENDER)) {
				event.setCancelled(true);
		}
	}
}
	
	@EventHandler(priority = EventPriority.HIGHEST,ignoreCancelled = true)
	public void damageListener(final EntityDamageByEntityEvent event)
	{
		Entity one = event.getDamager();
		if(one.getType() == EntityType.PLAYER && event.getEntity().getType() == EntityType.PLAYER)
		{
			Player damager = (Player)one;
			ItemStack teleport = new ItemStack(Material.EYE_OF_ENDER);
			if(damager.getInventory().getItemInHand().getType() == teleport.getType()) {
				
				if(rand.nextInt(100) < 37)
					((LivingEntity) event.getDamager()).addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 40, 3));
			}
		}
	}



}
