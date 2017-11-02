package me.jazzbro.killh;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public static String PREFIX = "§7[§3+§7]§bDEATH§7[§3+§7] ";
	
	public void onEnable( ) {
		getLogger().info("KillHeal enabled!");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	public void onDisable( ) {
		getLogger().info("KillHeal Disabled!");
	}
	
	@EventHandler
	public void onDeath (PlayerDeathEvent event) {
	 Player p = event.getEntity();
	 Player k = p.getKiller();
	 
	 Bukkit.getServer().broadcastMessage(PREFIX + ChatColor.RED + p.getName() + ChatColor.GOLD + " was killed by " + ChatColor.GREEN + p.getKiller().getName());
	 k.playSound(k.getLocation(), Sound.ORB_PICKUP, 10, 1);
	 k.sendMessage(PREFIX + ChatColor.GREEN + "+$12 for kill");
	 
 }

}
