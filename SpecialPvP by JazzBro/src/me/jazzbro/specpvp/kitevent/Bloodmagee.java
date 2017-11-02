package me.jazzbro.specpvp.kitevent;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
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

import me.jazzbro.specpvp.mainpack.Main;

public class Bloodmagee implements Listener{
	
	private Random rand;
	protected void setUp()
	{
		rand = new Random();
	}
	
	ArrayList<Player> blocooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack bloodsuck = new ItemStack(Material.REDSTONE);
		
		ItemMeta jim = bloodsuck.getItemMeta();
		jim.setDisplayName(ChatColor.RED + "BloodSuck");
		bloodsuck.setItemMeta(jim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == bloodsuck.getType()) {
				if(bloodsuck.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "BloodSuck")) {
				if(blocooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 40 second cooldown!");
				}
				if (!(blocooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    event.getPlayer().sendMessage(ChatColor.AQUA + "You have harvested the blood of your enemy!");
			    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 140, 3));
			    blocooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        blocooldown.remove(event.getPlayer());
                        event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "Your " + ChatColor.AQUA + "Ability " + ChatColor.GRAY + "is ready for use!" );
                }
                } , 800);
        event.setCancelled(true);
        
				
				}
				}
			}
		}
	}
}
	
	@EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
	public void damageHandler(EntityDamageByEntityEvent event) 
	{
		if(event.getDamager().getType() == EntityType.PLAYER) {
			Player player = (Player)event.getDamager();
			ItemStack ironHoe = new ItemStack(Material.IRON_HOE);
			
			if(player.getInventory().getItemInHand().getType() == ironHoe.getType()) {
				if(ironHoe.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "BloodSuck")) {
				if(rand.nextInt(3) == 1)
				{
					double health = player.getHealth()+1D;
					if(health > player.getMaxHealth())
						health = player.getMaxHealth();
					player.setHealth(health);
					player.playSound(player.getLocation(), Sound.EAT, 10, 1);
				}
				}
			}
		}
	}


}
