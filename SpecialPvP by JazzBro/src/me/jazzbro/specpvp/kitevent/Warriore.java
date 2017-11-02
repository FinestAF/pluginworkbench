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

public class Warriore implements Listener{

ArrayList<Player> warcooldown = new ArrayList<Player>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		ItemStack warriora = new ItemStack(Material.BLAZE_POWDER);
		
		ItemMeta wim = warriora.getItemMeta();
		wim.setDisplayName(ChatColor.GOLD + "Attack!");
		warriora.setItemMeta(wim);
		
		if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_AIR) {
			if(player.getInventory().getItemInHand().getType() == warriora.getType()) {
				if(warriora.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Attack!")) {
				if(warcooldown.contains(event.getPlayer())) {
					event.getPlayer().sendMessage(Main.PREFIX + ChatColor.GRAY + "This item has a 30 second cooldown!");
				}
				if (!(warcooldown.contains(event.getPlayer()))) {
				event.setCancelled(true); {
			    player.sendMessage(ChatColor.AQUA + "Your damage has increased!");
			    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
			    player.playSound(player.getLocation(), Sound.ENDERMAN_SCREAM, 10, 1);
			    warcooldown.add(event.getPlayer());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    public void run() {
                        warcooldown.remove(event.getPlayer());
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
