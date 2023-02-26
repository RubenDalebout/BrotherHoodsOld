package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.commands.Kingdom;
import io.github.rubendalebout.brotherhoods.commands.Kingdoms;
import org.bukkit.command.PluginCommand;

public class CommandManager {

    public CommandManager(BrotherHoods plugin) {
        PluginCommand kdCommand = plugin.getCommand("kingdom");
        Kingdom kingdom = new Kingdom(plugin);
        kdCommand.setExecutor(kingdom);
        kdCommand.setTabCompleter(kingdom);

        PluginCommand kdsCommand = plugin.getCommand("kingdoms");
        Kingdoms kingdoms = new Kingdoms(plugin);
        kdsCommand.setExecutor(kingdoms);
        kdsCommand.setTabCompleter(kingdoms);
    }
}
