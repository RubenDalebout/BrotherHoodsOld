package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Brotherhood implements CommandExecutor, TabCompleter {
    private final BrotherHoods plugin;

    public Brotherhood(BrotherHoods plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if user has the permissions
        if (!sender.hasPermission("brotherhoods.brotherhood")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("no-permission"), true));
            return true;
        }

        // Check if there are arguments
        if (args.length > 0) {

            return true;
        }

        // No arguments so check if user is in a Brotherhood
        if (false) {
            return true;
        }

        // Send user a message that he/she is not in a brotherhood
        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-not-in"), true));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        return completions;
    }
}
