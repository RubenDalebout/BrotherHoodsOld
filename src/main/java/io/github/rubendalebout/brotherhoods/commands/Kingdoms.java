package io.github.rubendalebout.brotherhoods.commands;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.Kingdom;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

        if (!(sender instanceof Player) || !plugin.getConfigManager().getGeneralConfiguration().getBoolean("g-kingdoms")) {
            sender.sendMessage(plugin.getFormat().color(plugin.getKingdomManager().getKingdomList()
                    .stream()
                    .map(Kingdom::getDisplayName)
                    .collect(Collectors.joining(", ")), true));
            return true;
        }

        this.openGUI((Player) sender);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        return completions;
    }

    private void openGUI(Player player) {
        List<Kingdom> kingdoms = plugin.getKingdomManager().getKingdomList();
        int rows = (int) Math.ceil(kingdoms.size() / 9.0);
        int slots = rows * 9;

        Inventory gui = Bukkit.createInventory(player, slots, plugin.getFormat().color("&6&lKingdom(s)", false));

        for (int i = 0; i < kingdoms.size(); i++) {
            Kingdom kingdom = kingdoms.get(i);
            ItemStack item = kingdom.getDisplayItem();
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(plugin.getFormat().color("&7" + kingdom.getDisplayName(), false));
            item.setItemMeta(meta);
            gui.setItem(i, item);
        }

        player.openInventory(gui);
    }
}
