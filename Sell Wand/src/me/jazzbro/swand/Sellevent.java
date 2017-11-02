package me.jazzbro.swand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sellevent implements Listener{
	
	public static String PREFIX = "§8[§b§lJSellWand§8] ";
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = (Player) e.getPlayer();
        ItemStack swand = new ItemStack(Material.STICK);
        Block block = e.getClickedBlock();
        
		
		ItemMeta im = swand.getItemMeta();
		im.setDisplayName(ChatColor.GOLD + "Sell Wand");
		swand.setItemMeta(im);
		
		
		if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
			if(p.getInventory().getItemInHand().equals(swand)) {
				if(swand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Sell Wand")) {
					if(block.getType().equals(Material.CHEST)) {
						if(!(p.getInventory().getSize() == p.getInventory().getMaxStackSize())) {
							p.sendMessage(PREFIX + ChatColor.RED + "Your Inventory is full!");
						}
						else {
							Inventory inv = ((InventoryHolder) block.getState()).getInventory();
							for(ItemStack stuff : inv.getContents()) {
								if(!(stuff != null)) {
									p.sendMessage(PREFIX + ChatColor.DARK_AQUA + "This chest contains " + ChatColor.GREEN +
									stuff);
								}
							for(ItemStack bstuff : inv.getContents()) {

								if(!(bstuff != null)) {
									p.getInventory().addItem(bstuff);
								}
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
							public void run() {
								p.performCommand("sell all");
								p.getInventory().remove(bstuff);;
								p.sendMessage(PREFIX + ChatColor.DARK_GREEN + "You have sold the items from the chest!");
							
							}
							}, 40);
						
						
			
						
						
					}
					}
					}
						}
					}
				}
		}
	}
}
