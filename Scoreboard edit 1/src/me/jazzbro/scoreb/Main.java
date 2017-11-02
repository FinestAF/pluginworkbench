package me.jazzbro.scoreb;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener{
	
    @Override
	public void onEnable() {
		getLogger().info("JScoreboards enabled");
		
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		
	}
    
	@Override
	public void onDisable() {
		getLogger().info("JScoreboards Disabled");
	}
	
	private static Main INSTANCE;
	  
	   public Main() {
	      INSTANCE = this;
	   }
	  
	   public static Main getInstance() {
	      return INSTANCE;
	   }
	 
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&7[&2+&7]" + ChatColor.DARK_GREEN + p.getName()));
		//
		
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				ScoreboardManager manager = Bukkit.getScoreboardManager();
				Scoreboard board = manager.getNewScoreboard();
				Objective objective = board.registerNewObjective("test", "dummy");
				objective.setDisplaySlot(DisplaySlot.SIDEBAR);
				objective.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7[&3+&7]&bHarmonyCraft&7[&3+&7]"));
				
				Score scorebla = objective.getScore(ChatColor.AQUA + " ");
				scorebla.setScore(5);
				Score scoreblank = objective.getScore(ChatColor.GRAY + "-----------------------");
				scoreblank.setScore(-1);
				Score scoreblan = objective.getScore(ChatColor.GREEN + " ");
				scoreblan.setScore(2);
				
				
				Score scorea = objective.getScore(ChatColor.GRAY + "----------------------");
				scorea.setScore(9);
				
				Score score = objective.getScore(ChatColor.GREEN+ " You:");
				score.setScore(7);
				
				Score score1 = objective.getScore(p.getDisplayName());
				score1.setScore(6);
				
				Score score3 = objective.getScore(ChatColor.GOLD + " World:");
				score3.setScore(4);
				
				Score score4 = objective.getScore(ChatColor.WHITE + " You are in " + ChatColor.GOLD + p.getLocation().getWorld().getWorldFolder().getName());
				score4.setScore(3);
				
				Score score6 = objective.getScore(ChatColor.LIGHT_PURPLE + " Players Online:");
				score6.setScore(1);
				
				Score score7 = objective.getScore(ChatColor.WHITE + " There are " + ChatColor.LIGHT_PURPLE + Bukkit.getServer().getOnlinePlayers().size() + ChatColor.WHITE + " players online.");
				score7.setScore(0);
				
				Score score9 = objective.getScore(ChatColor.DARK_AQUA + " HarmonyCraft.ml");
				score9.setScore(-2);
				
				p.setScoreboard(board);
				
			}
		}, 0, 20 * 10);
	 
		
		
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&7[&c-&7]" + ChatColor.RED + p.getName()));
		
	}
 
}
