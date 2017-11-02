package me.jazzbro.chatblock;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable() {
		getLogger().info("ChatBlock enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable() {
		getLogger().info("ChatBlock Disabled!");
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(!(e.getPlayer().hasPermission("chatb.bypass"))) {
			e.setCancelled(true);
		}
	}
	

}
