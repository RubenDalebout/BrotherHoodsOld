package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.Kingdom;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Kingdoms implements CommandExecutor, TabCompleter {
    private final BrotherHoods plugin;

    public Kingdoms(BrotherHoods plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("brotherhoods.kingdoms")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("no-permission"), true));
            return true;
        }

        if (!(sender instanceof Player) || !plugin.getConfigManager().getGeneralConfiguration().getBoolean("kingdom-list")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getKingdomManager().getKingdomList()
                    .stream()
                    .map(Kingdom::getDisplayName)
                    .collect(Collectors.joining(", ")), true));
            return true;
        }

        sender.sendMessage(plugin.getFormat().color("&cNog in ontwikkeling", true));

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        return completions;
    }
}
