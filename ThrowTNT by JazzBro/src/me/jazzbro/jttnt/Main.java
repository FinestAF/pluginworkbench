package me.jazzbro.jttnt;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("JThrowTNT Enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getCommand("jtnt").setExecutor(new Commandc());
	}
	
	public void onDisable() {
		getLogger().info("JThrowTNT Disabled!");
	}
	
	@EventHandler
    public void onPlayerInteract(PlayerInteractEvent e){
    Player p = e.getPlayer();
    
    ItemStack stnt = new ItemStack(Material.TNT);
	
	ItemMeta im = stnt.getItemMeta();
	im.setDisplayName(ChatColor.YELLOW + "Throwing tnt");
	stnt.setItemMeta(im);
    
	if(e.getAction() == Action.LEFT_CLICK_AIR) {
		if(p.getInventory().getItemInHand().getType() == stnt.getType()) {
			if(stnt.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.YELLOW + "Firestorm")) {
				p.getInventory().removeItem(new ItemStack(Material.TNT, 1));
				TNTPrimed tnt = (TNTPrimed) p.getWorld().spawn(p.getLocation(), TNTPrimed.class);
				tnt.setVelocity(p.getLocation().getDirection().normalize().multiply(2));
        }
	}
	}
	}

}
