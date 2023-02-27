package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

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

        // Check if sender is not a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getFormat().color("&cKan alleen als speler", true));
            return true;
        }

        Player player = (Player) sender;

        // Check if there are arguments
        if (args.length > 0) {
            String subcommand = args[0];

            // Create brotherhood
            if (subcommand.equalsIgnoreCase("create") && sender.hasPermission("brotherhood.create")) {
                if (args.length == 2) {
                    String displayName = args[1];
                    String name = displayName.toLowerCase().replaceAll("[^a-zA-Z0-9-]", "").replace(" ", "-");

                    // Check if user is already in a brotherhood
                    if (plugin.getPlayerManager().getBrotherhood(player.getUniqueId()) != null) {
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-already-in"), true));
                        return true;
                    }

                    // Check if brotherhood exists
                    if (plugin.getBrotherhoodManager().getBrotherhood(null, name) == null) {
                        io.github.rubendalebout.brotherhoods.classes.Brotherhood brotherhood = new io.github.rubendalebout.brotherhoods.classes.Brotherhood(name)
                                .setDisplayName(displayName);

                        try {
                            brotherhood.addPlayer(player.getUniqueId());
                            plugin.getBrotherhoodManager().addBrotherhood(brotherhood);
                        } catch (Exception e) {
                            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-create-failure"), true));
                            return true;
                        }

                        // Set for the player the brotherhood UUID
                        plugin.getPlayerManager().setPlayerBrotherhood(player.getUniqueId(), brotherhood.getId());
                        sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-create-success"), true));
                        return  true;
                    }

                    // Brotherhood exists
                    sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-create-exists"), true));
                    return true;
                }

                sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhood-create-arguments"), true));
                return true;
            }
        }

        // No arguments so check if user is in a Brotherhood
        if (plugin.getPlayerManager().getBrotherhood(player.getUniqueId()) != null) {
            sender.sendMessage("brotherhood informatie");
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
