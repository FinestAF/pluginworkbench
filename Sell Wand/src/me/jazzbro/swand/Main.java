package me.jazzbro.swand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	public void onEnable() {
		getLogger().info("SellWand Enabled!");
		getCommand("sellwand").setExecutor(new Stickcommand());
		getServer().getPluginManager().registerEvents(new Sellevent(), this);
	}
	
	public void onDisable() {
		getLogger().info("SellWand Disabled!");
	}
	
	private static Main INSTANCE;
	  
	   public Main() {
	      INSTANCE = this;
	   }
	  
	   public static Main getInstance() {
	      return INSTANCE;
	   }

}
