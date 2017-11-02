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

public class Jammere implements Listener{
	
ArrayList<Player> jamcooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack stoneHoe = new ItemStack(Material.STONE_HOE);
		
		ItemMeta jim = stoneHoe.getItemMeta();
		jim.setDisplayName(ChatColor.GRAY + "Cloak");
		stoneHoe.setItemMeta(jim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == stoneHoe.getType()) {
				if(stoneHoe.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Cloak")) {
				if(jamcooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 30 second cooldown!");
				}
				if (!(jamcooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    event.getPlayer().sendMessage(ChatColor.AQUA + "You have covered yourself!");
			    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 300, 1));
			    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0));
			    player.playSound(player.getLocation(), Sound.ENDERDRAGON_WINGS, 10, 1);
			    jamcooldown.add(event.getPlayer());
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        jamcooldown.remove(event.getPlayer());
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
