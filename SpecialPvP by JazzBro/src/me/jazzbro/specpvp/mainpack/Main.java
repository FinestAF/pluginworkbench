package me.jazzbro.specpvp.mainpack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.jazzbro.specpvp.Archerc;
import me.jazzbro.specpvp.Blazec;
import me.jazzbro.specpvp.Bloodmagec;
import me.jazzbro.specpvp.Endermagec;
import me.jazzbro.specpvp.Jammerc;
import me.jazzbro.specpvp.Ninjac;
import me.jazzbro.specpvp.Peasantc;
import me.jazzbro.specpvp.Snowmanc;
import me.jazzbro.specpvp.Warriorc;
import me.jazzbro.specpvp.Waterheal;
import me.jazzbro.specpvp.Waterrefill;
import me.jazzbro.specpvp.kitbuy.Archerb;
import me.jazzbro.specpvp.kitbuy.Blazeb;
import me.jazzbro.specpvp.kitbuy.Bloodmageb;
import me.jazzbro.specpvp.kitbuy.Endermageb;
import me.jazzbro.specpvp.kitbuy.Jammerb;
import me.jazzbro.specpvp.kitbuy.Ninjab;
import me.jazzbro.specpvp.kitbuy.Snowmanb;
import me.jazzbro.specpvp.kitbuy.Warriorb;
import me.jazzbro.specpvp.kitevent.Archere;
import me.jazzbro.specpvp.kitevent.Blazee;
import me.jazzbro.specpvp.kitevent.Bloodmagee;
import me.jazzbro.specpvp.kitevent.Endermagee;
import me.jazzbro.specpvp.kitevent.Jammere;
import me.jazzbro.specpvp.kitevent.Ninjae;
import me.jazzbro.specpvp.kitevent.Peasante;
import me.jazzbro.specpvp.kitevent.Snowmane;
import me.jazzbro.specpvp.kitevent.Warriore;
import me.jazzbro.specpvp.kitsels.Buyselector;
import me.jazzbro.specpvp.kitsels.Kitselector;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand.EnumClientCommand;

public class Main extends JavaPlugin implements Listener{
	
	  public static String PREFIX = "§7[§3+§7]§bDEATH§7[§3+§7] ";
	  public static Economy econ = null;
	  
	public void onEnable() {
		if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
		getLogger().info("SpecialPvP enabled");
		getServer().getPluginManager().registerEvents(new Waterheal(), this);
		getServer().getPluginManager().registerEvents(this, this);
		getServer().getPluginManager().registerEvents(new Warriore(), this);
		getServer().getPluginManager().registerEvents(new Jammere(), this);
		getServer().getPluginManager().registerEvents(new Peasante(), this);
		getServer().getPluginManager().registerEvents(new Archere(), this);
		getServer().getPluginManager().registerEvents(new Ninjae(), this);
		getServer().getPluginManager().registerEvents(new Snowmane(), this);
		getServer().getPluginManager().registerEvents(new Blazee(), this);
		getServer().getPluginManager().registerEvents(new Bloodmagee(), this);
		getServer().getPluginManager().registerEvents(new Endermagee(), this);
		getServer().getPluginManager().registerEvents(new Kitselector(), this);
		getServer().getPluginManager().registerEvents(new Buyselector(), this);
		getCommand("peasant").setExecutor(new Peasantc());
		getCommand("warrior").setExecutor(new Warriorc());
		getCommand("jammer").setExecutor(new Jammerc());
		getCommand("archer").setExecutor(new Archerc());
		getCommand("ninja").setExecutor(new Ninjac());
		getCommand("snowman").setExecutor(new Snowmanc());
		getCommand("blaze").setExecutor(new Blazec());
		getCommand("bloodmage").setExecutor(new Bloodmagec());
		getCommand("endermage").setExecutor(new Endermagec());
		getCommand("refill").setExecutor(new Waterrefill());
		// buy kits
		getCommand("barcher").setExecutor(new Archerb());
		getCommand("bblaze").setExecutor(new Blazeb());
		getCommand("bbloodmage").setExecutor(new Bloodmageb());
		getCommand("bendmage").setExecutor(new Endermageb());
		getCommand("bjammer").setExecutor(new Jammerb());
		getCommand("bninja").setExecutor(new Ninjab()); 
		getCommand("bsnowman").setExecutor(new Snowmanb());
		getCommand("bwarrior").setExecutor(new Warriorb());
	}

	public void pnDisable() {
		getLogger().info("SpecialPvP Disabled!");
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

	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		ItemStack kitsel = new ItemStack(Material.EMERALD);
		ItemStack kitbuy = new ItemStack(Material.DIAMOND);
		
		ItemMeta kim = kitsel.getItemMeta();
		kim.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lKit Selector"));
		kitsel.setItemMeta(kim);
		
		ItemMeta bim = kitbuy.getItemMeta();
		bim.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lKit Shop"));
		kitbuy.setItemMeta(bim);
		
		player.getInventory().clear();
		for (PotionEffect effect : player.getActivePotionEffects())
		        player.removePotionEffect(effect.getType());
		player.teleport(player.getLocation().getWorld().getSpawnLocation());
		player.setMaxHealth(20.0);
		player.setHealth(player.getPlayer().getMaxHealth());
	    if(!(player.getInventory().contains(kitsel))) {
	    	player.getInventory().setItem(0, kitsel);
	    }
	    if(!(player.getInventory().contains(kitbuy))) {
	    	player.getInventory().setItem(1, kitbuy);
	    }
	    	
	    
	    
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		ItemStack kitsel = new ItemStack(Material.EMERALD);
		ItemStack kitbuy = new ItemStack(Material.DIAMOND);
		
		ItemMeta kim = kitsel.getItemMeta();
		kim.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lKit Selector"));
		kitsel.setItemMeta(kim);
		
		ItemMeta bim = kitbuy.getItemMeta();
		bim.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lKit Shop"));
		kitbuy.setItemMeta(bim);
		
		event.getPlayer().setMaxHealth(24.0);
	    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 3));
	    player.getInventory().setItem(0, kitsel);
	    player.getInventory().setItem(1, kitbuy);
	    player.setMaxHealth(20.0);
	}
	 @EventHandler
     public void repairWeapons(EntityDamageByEntityEvent e){
             if(e.getDamager() instanceof Player){
                     ((Player) e.getDamager()).getInventory().getItemInHand().setDurability((short) -1);
             }else if(e.getEntity() instanceof Player){
                     ItemStack[] armor = ((Player) e.getEntity()).getInventory().getArmorContents();
                     for(ItemStack i : armor){
                             i.setDurability((short)0);
                     }
             }
     }
	 
	 @EventHandler
	 public void onPlayerDropItem(PlayerDropItemEvent event) {
		 event.setCancelled(true);
		 event.getPlayer().sendMessage(ChatColor.DARK_RED + "You may not drop your items!");
	 }
	 
	 @EventHandler
	 public void onItemSpawn(ItemSpawnEvent event) {
		 event.setCancelled(true);
	 }
	 
	 public void Respawn(final Player player,int Time){
         Bukkit.getScheduler().runTaskLater(this, new Runnable() {
                       
                         @Override
                        public void run() {
                               ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
                     }
               },Time);
   }
	 
	 @EventHandler
		public void onDeath (PlayerDeathEvent event) {
		 Player p = event.getEntity();
		 Player k = p.getKiller();
	       Respawn(p,1);
		 if(event.getEntity() instanceof Player){
	            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "eco give " + k.getName() + " 12");
	        }
		 
	 }
		
	 
	 @EventHandler
		public void onQuit(PlayerQuitEvent event) {
		 Inventory inv = event.getPlayer().getInventory();
		 Player player = event.getPlayer();
		 
		 inv.clear();
		 for (PotionEffect effect : player.getActivePotionEffects())
		        player.removePotionEffect(effect.getType());
		 player.setMaxHealth(20.0);
			player.setHealth(player.getPlayer().getMaxHealth());
			player.getInventory().setHelmet(null);
			player.getInventory().setChestplate(null);
			player.getInventory().setLeggings(null);
			player.getInventory().setBoots(null);
		 
	 }
	 
	 
	
}
