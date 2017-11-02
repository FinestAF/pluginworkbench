package me.jazzbro.electricbar;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Eventcl implements Listener{
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerWalkInBar(PlayerMoveEvent e) {
	      
        Player p = (Player) e.getPlayer();
      
        if(p.getLocation().getBlock().getType() == Material.IRON_FENCE || p.getEyeLocation().getBlock().getType() == Material.IRON_FENCE) {
        	if(!(p.getActivePotionEffects() == (PotionEffectType.WITHER))) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 4));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 3));
            p.sendMessage(ChatColor.RED + "This is an electric fence!");
        	}
        }
        else { Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            public void run() {
            	p.removePotionEffect(PotionEffectType.WITHER);
            	p.removePotionEffect(PotionEffectType.SLOW);
        }
        } , 60);
    }
	}
}
