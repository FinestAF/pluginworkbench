package me.jazzbro.specpvp;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Waterheal implements Listener{
	
	@EventHandler
	public void onPlayerClick(PlayerInteractEvent event){
		Player player = event.getPlayer();

		if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)){
		if (player.getItemInHand().getType() == Material.POTION) {
			if(!(player.getHealth() == player.getMaxHealth())) {
			player.playSound(player.getLocation(), Sound.DRINK, 10, 1);
			player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 1));
			player.getInventory().getItemInHand().setType(Material.GLASS_BOTTLE);
			player.getInventory().remove(Material.GLASS_BOTTLE);
			
			}
			}
			
				}
		}

}
