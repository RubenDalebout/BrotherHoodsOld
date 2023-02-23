package io.github.rubendalebout.brotherhoods;

import io.github.rubendalebout.brotherhoods.managers.CommandManager;
import io.github.rubendalebout.brotherhoods.managers.ConfigManager;
import io.github.rubendalebout.brotherhoods.managers.KingdomManager;
import io.github.rubendalebout.brotherhoods.utils.ChatFormat;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class BrotherHoods extends JavaPlugin {

    private ConsoleCommandSender console;
    private ChatFormat format;
    private ConfigManager configManager;
    private KingdomManager kingdomManager;
    private CommandManager commandManager;
    @Override
    public void onEnable() {
        // Console
        console = getServer().getConsoleSender();
        // Utils
        format = new ChatFormat(this);
        // Configurations
        configManager = new ConfigManager(this);
        // Load kingdoms
        kingdomManager = new KingdomManager(this);
        // Set commands
        commandManager = new CommandManager(this);

        // Plugin startup logic
        console.sendMessage(format.color("&aPlugin opgestart", true));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ConsoleCommandSender getConsole() {
        return this.console;
    }

    public ChatFormat getFormat() {
        return this.format;
    }
    public ConfigManager getConfigManager() {
        return this.configManager;
    }

    public KingdomManager getKingdomManager() {
        return kingdomManager;
    }
}
