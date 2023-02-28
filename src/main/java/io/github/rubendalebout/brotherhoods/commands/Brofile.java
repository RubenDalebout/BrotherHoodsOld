package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Brofile implements CommandExecutor {
    private final BrotherHoods plugin;

    public Brofile(BrotherHoods plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("brotherhoods.brofile")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("no-permission"), true));
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage(plugin.getFormat().color(plugin.getConfigManager().getGeneralConfiguration().getString("only-console"), true));
            return true;
        }

        Player player = (Player) sender;

        String Brotherhood = (plugin.getPlayerManager().playerExists(player.getUniqueId()) && plugin.getPlayerManager().getBrotherhood(player.getUniqueId()) != null && plugin.getBrotherhoodManager().getBrotherhood(plugin.getPlayerManager().getBrotherhood(player.getUniqueId()), null) != null) ? plugin.getBrotherhoodManager().getBrotherhood( plugin.getPlayerManager().getBrotherhood(player.getUniqueId()), null).getDisplayName() : plugin.getConfigManager().getGeneralConfiguration().getString("no-brotherhood");

        String[] brofile = {
                plugin.getFormat().color("&c&lUsername: &c" + ((Player) sender).getDisplayName(), false),
                plugin.getFormat().color("&c&lBrotherhood: &c" + Brotherhood, false),
        };

        sender.sendMessage(brofile);
        return true;
    }
}
