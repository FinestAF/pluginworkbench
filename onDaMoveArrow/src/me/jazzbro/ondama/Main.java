package me.jazzbro.ondama;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable( ) {
		getLogger().info("onDaMoveArrow enabled!");
		Bukkit.getServer().getPluginManager().registerEvents(new Player(), this);
	}
	
	
	public void onDisable( ) {
		getLogger().info("onDaMoveArrow Disabled!");
	}
	

}
