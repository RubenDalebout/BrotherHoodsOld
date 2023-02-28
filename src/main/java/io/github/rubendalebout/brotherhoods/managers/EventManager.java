package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.listeners.OnInventoryClick;
import io.github.rubendalebout.brotherhoods.listeners.OnJoin;
import io.github.rubendalebout.brotherhoods.listeners.OnTabComplete;

public class EventManager {

    public EventManager(BrotherHoods plugin) {
        plugin.getServer().getPluginManager().registerEvents(new OnJoin(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new OnTabComplete(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new OnInventoryClick(), plugin);
    }
}
