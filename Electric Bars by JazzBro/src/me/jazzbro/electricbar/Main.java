package me.jazzbro.electricbar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	
	public void onEnable() {
		getLogger().info("ElectricFence Enabled!");
		Bukkit.getPluginManager().registerEvents(new Eventcl(), this);
	}
	
	public void onDisable() {
		getLogger().info("ElectricFence Disabled!");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	 private static Main INSTANCE;
	  
	   public Main() {
	      INSTANCE = this;
	   }
	  
	   public static Main getInstance() {
	      return INSTANCE;
	   }
}