package me.jazzbro.ondama;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Player implements Listener{
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		org.bukkit.entity.Player p = e.getPlayer();
		
		if(p.getInventory().getItemInHand().getType() == Material.ARROW) {
			p.launchProjectile(Arrow.class);
			
			p.sendMessage(ChatColor.GOLD + "Launching arrow!");
			
			
		}
		
		
		
	}

}
