package io.github.rubendalebout.brotherhoods.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class OnInventoryClick implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory != null && clickedInventory.equals(player.getOpenInventory().getTopInventory())) {
            String inventoryTitle = ChatColor.stripColor(clickedInventory.getTitle());
            if (inventoryTitle.equalsIgnoreCase("Kingdom(s)")) {
                event.setCancelled(true);
            }
        }
    }
}
