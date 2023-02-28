package io.github.rubendalebout.brotherhoods.listeners;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    private final BrotherHoods plugin;

    public OnJoin(BrotherHoods plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Check if user is in the playerList
        if (!plugin.getPlayerManager().playerExists(event.getPlayer().getUniqueId())) {
            plugin.getPlayerManager().addPlayer(event.getPlayer().getUniqueId());
        }
    }
}
