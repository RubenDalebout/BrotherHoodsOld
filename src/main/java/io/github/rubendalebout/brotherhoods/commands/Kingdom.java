package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class Kingdom implements CommandExecutor, TabCompleter {

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
                // Check if there is only 2 arguments given
                if (args.length == 2) {
                    String name = args[1];
                    String formattedName = name.toLowerCase().replaceAll("[^a-zA-Z0-9-]", "").replace(" ", "-");

                    // Check if kingdom already exists
                    if (plugin.getKingdomManager().kingdomExists(formattedName)) {
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-add-exists"), true));
                        return true;
                    }
                    io.github.rubendalebout.brotherhoods.classes.Kingdom kingdom = new io.github.rubendalebout.brotherhoods.classes.Kingdom(formattedName)
                            .setDisplayName(name);

                    try {
                        plugin.getKingdomManager().addKingdom(kingdom);
                    } catch (Exception e) {
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-add-error"), true));
                        return true;
                    }
                    sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-add-success"), true));
                    return true;
                }
                sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-add-arguments"), true));
                return true;
            }

            // Check if argument 0 is remove
            if (args[0].equalsIgnoreCase("remove")) {
                // Check if there is only 2 arguments given
                if (args.length == 2) {
                    // Remove kingdom from the list if it exists
                    if (plugin.getKingdomManager().kingdomExists(args[1])) {
                        try {
                            plugin.getKingdomManager().removeKingdom(plugin.getKingdomManager().getKingdom(null, args[1]).getId());
                        } catch (Exception e) {
                            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-remove-error"), true));
                            return true;
                        }
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-remove-success"), true));
                    } else {
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-remove-not-exist"), true));
                    }
                    return true;
                }
                sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-remove-arguments"), true));
                return true;
            }
        }

        // Send the arguments to the user
        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-kingdom-arguments"), true));
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        // Args 0
        if (args.length == 0) {
            // Add permission
            if (sender.hasPermission("brotherhoods.kingdom.add")) completions.add("add");
            // Remove permission
            if (sender.hasPermission("brotherhoods.kingdom.remove")) completions.add("remove");
        }

        // Args 1 with add or remove
        if (args.length == 1 && (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove"))) {
            // Add or remove permission
            if ((args[0].equalsIgnoreCase("add") && sender.hasPermission("brotherhoods.kingdom.add")) ||
                    (args[0].equalsIgnoreCase("remove") && sender.hasPermission("brotherhoods.kingdom.remove"))) {
                // Add the list of kingdoms
                for(io.github.rubendalebout.brotherhoods.classes.Kingdom kingdom : plugin.getKingdomManager().getKingdomList()) {
                    completions.add(kingdom.getName());
                }
            }
        }

        return completions;
    }
}
