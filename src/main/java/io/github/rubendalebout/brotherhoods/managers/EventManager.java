package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.listeners.OnTabComplete;

public class EventManager {

    public EventManager(BrotherHoods plugin) {
        plugin.getServer().getPluginManager().registerEvents(new OnTabComplete(plugin), plugin);
    }
}
