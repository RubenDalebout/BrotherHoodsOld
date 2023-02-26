package io.github.rubendalebout.brotherhoods.listeners;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.TabCompleteEvent;

import java.util.List;

public class OnTabComplete implements Listener {
    private final BrotherHoods plugin;

    public OnTabComplete(BrotherHoods plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {
        List<String> completions = event.getCompletions();
        // Check if its a suggestion for a command
        if (event.getBuffer().startsWith("/")) {
            // Delete some important commands
            completions.remove("/brotherhoods:kingdom");
            if (!event.getSender().hasPermission("brotherhoods.kingdom.add") && !event.getSender().hasPermission("brotherhoods.kingdom.remove")) completions.remove("/kingdom");
            completions.remove("/brotherhoods:kingdomlist");
            if (!event.getSender().hasPermission("brotherhoods.kingdoms")) completions.remove("/kingdomlist");
            completions.remove("/brotherhoods:kingdoms");
            if (!event.getSender().hasPermission("brotherhoods.kingdoms")) completions.remove("/kingdoms");
            completions.remove("/brotherhoods:ks");
            if (!event.getSender().hasPermission("brotherhoods.kingdoms")) completions.remove("/ks");
            completions.remove("/brotherhoods:kingdomlist");
            if (!event.getSender().hasPermission("brotherhoods.kingdoms")) completions.remove("/kingdomlist");
            completions.remove("/brotherhoods:klist");
            if (!event.getSender().hasPermission("brotherhoods.kingdoms")) completions.remove("/klist");
        }

        event.setCompletions(completions);
    }
}
