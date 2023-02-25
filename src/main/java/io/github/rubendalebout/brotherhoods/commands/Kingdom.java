package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Kingdom implements CommandExecutor {

    private final BrotherHoods plugin;

    public Kingdom(BrotherHoods plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if user has the permissions
        if (!sender.hasPermission("brotherhoods.kingdom.add") && !sender.hasPermission("brotherhoods.kingdom.remove")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("no-permission"), true));
            return true;
        }

        // Check if there are arguments
        if (args.length > 0) {
            // Check if argument 0 is add
            if (args[0].equalsIgnoreCase("add")) {

                return true;
            }

            // Check if argument 0 is remove
            if (args[0].equalsIgnoreCase("remove")) {

                return true;
            }
        }

        // Send the arguments to the user
        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-arguments"), true));
        return true;
    }
}
