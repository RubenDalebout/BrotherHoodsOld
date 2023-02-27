package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.commands.Brotherhood;
import io.github.rubendalebout.brotherhoods.commands.Brotherhoods;
import io.github.rubendalebout.brotherhoods.commands.Kingdom;
import io.github.rubendalebout.brotherhoods.commands.Kingdoms;
import org.bukkit.command.PluginCommand;

public class CommandManager {

    public CommandManager(BrotherHoods plugin) {
        PluginCommand bhCommand = plugin.getCommand("brotherhood");
        Brotherhood brotherhood = new Brotherhood(plugin);
        bhCommand.setExecutor(brotherhood);
        bhCommand.setTabCompleter(brotherhood);

        PluginCommand bhsCommand = plugin.getCommand("brotherhoods");
        Brotherhoods brotherhoods = new Brotherhoods(plugin);
        bhsCommand.setExecutor(brotherhoods);
        bhsCommand.setTabCompleter(brotherhoods);

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
