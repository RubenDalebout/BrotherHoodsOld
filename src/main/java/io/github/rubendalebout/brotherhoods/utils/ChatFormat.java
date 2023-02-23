package io.github.rubendalebout.brotherhoods.utils;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.ChatColor;

public class ChatFormat {
    private final BrotherHoods plugin;

    public ChatFormat(BrotherHoods plugin) {
        this.plugin = plugin;
    }

    public String color(String text, Boolean prefix) {
        return ChatColor.translateAlternateColorCodes('&', (prefix) ? plugin.getConfigManager().getGeneralConfiguration().getString("prefix") + " &f" + text : text);
    }
}
