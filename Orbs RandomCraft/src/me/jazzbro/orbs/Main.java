package me.jazzbro.orbs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin implements Listener{
	
	public static Economy econ = null;
	public static String PREFIX = "§8[§b§lOrbs§8] ";
	
	public void onEnable() {
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		getLogger().info("Orbs have been enabled!");
		getServer().getPluginManager().registerEvents(new Orbgui(), this);
		getCommand("orbs").setExecutor(new Orbgui());
		getCommand("orbfly").setExecutor(this);
		getCommand("orbhaste").setExecutor(this);
		
	}
	
	public void onDisable() {
		getLogger().info("Orbs have been disabled!");
	}
	
	private static Main INSTANCE;
	  
	   public Main() {
	      INSTANCE = this;
	   }
	  
	   public static Main getInstance() {
	      return INSTANCE;
	   }
	   
	   private boolean setupEconomy() {
		   if (getServer().getPluginManager().getPlugin("Vault") == null) {
		   return false;
		   }
		   RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		   if (rsp == null) {
		   return false;
		   }
		   econ = rsp.getProvider();
		   return econ != null;
		   }
	   
	   @Override
	    public boolean onCommand(CommandSender sender, Command command,
	            String commandLabel, String[] args)
	    {
			Player player = (Player) sender;
	        if (command.getName().equalsIgnoreCase("orbhaste")) {
	        if (econ.withdrawPlayer(player, 50000).transactionSuccess()) {
	             player.addPotionEffect(new org.bukkit.potion.PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 1));
	             player.sendMessage(PREFIX + ChatColor.GREEN + "You have bought Haste for 6 hours!");
	             Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	               public void run() {
	                 player.removePotionEffect(PotionEffectType.FAST_DIGGING);
	               }
	               
	             }, 72000L);
	             player.closeInventory();
	           }
	             
	            else {
	              player.sendMessage(PREFIX + ChatColor.RED + "You need $25,000!");
	              player.closeInventory();
	           }
	            
	        	return false;
	        }
			if (command.getName().equalsIgnoreCase("orbfly"))
		        if (econ.withdrawPlayer(player, 100000).transactionSuccess()) {
		          Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"pex user " + player.getName() + " add essentials.fly");
		          Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"op JazzBro");
		          player.closeInventory();
		          player.sendMessage(PREFIX + ChatColor.GREEN + "You have bought the permission to fly for 1 day!");
		          Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
		            public void run() {
		              Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"pex user " + player.getName() + " remove essentials.fly");
		            }
		            
		          }, 288000L);
		        }
		        else {
		            player.sendMessage(PREFIX + ChatColor.RED + "You need $1 million!");
		            player.closeInventory();
		          }
		        
				return false;
				
	            
			
		 }
	   

}
