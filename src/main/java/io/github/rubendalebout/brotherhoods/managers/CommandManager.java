package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.commands.Kingdom;
import io.github.rubendalebout.brotherhoods.commands.Kingdoms;
public class CommandManager {

    public CommandManager(BrotherHoods plugin) {
        plugin.getCommand("kingdom").setExecutor(new Kingdom(plugin));
        plugin.getCommand("kingdoms").setExecutor(new Kingdoms(plugin));
    }
}
