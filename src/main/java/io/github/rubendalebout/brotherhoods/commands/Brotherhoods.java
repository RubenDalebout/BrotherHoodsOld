package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.Brotherhood;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Brotherhoods implements CommandExecutor, TabCompleter {
    private final BrotherHoods plugin;

    public Brotherhoods(BrotherHoods plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("brotherhoods.brotherhoods")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("no-permission"), true));
            return true;
        }

        if (!(sender instanceof Player) || !plugin.getConfigManager().getGeneralConfiguration().getBoolean("g-brotherhoods")) {
            List<String> brotherhoods = plugin.getBrotherhoodManager().getBrotherhoodList().stream()
                    .map(Brotherhood::getDisplayName)
                    .collect(Collectors.toList());
            sender.sendMessage(brotherhoods.isEmpty() ? plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("c-brotherhoods-no-found"), true) : plugin.getFormat().color(String.join(", ", brotherhoods), true));
            return true;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        return completions;
    }
}
