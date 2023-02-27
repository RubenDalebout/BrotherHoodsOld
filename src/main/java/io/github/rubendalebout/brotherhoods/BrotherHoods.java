package io.github.rubendalebout.brotherhoods;

import io.github.rubendalebout.brotherhoods.managers.*;
import io.github.rubendalebout.brotherhoods.utils.ChatFormat;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class BrotherHoods extends JavaPlugin {

    private ConsoleCommandSender console;
    private ChatFormat format;
    private ConfigManager configManager;
    private KingdomManager kingdomManager;
    private BrotherhoodManager brotherhoodManager;
    private PlayerManager playerManager;
    private EventManager eventManager;
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
        // Load Brotherhoods
        brotherhoodManager = new BrotherhoodManager(this);
        // Load players
        playerManager = new PlayerManager(this);
        // Set events
        eventManager = new EventManager(this);
        // Set commands
        commandManager = new CommandManager(this);

        // Plugin startup logic
        console.sendMessage(format.color(this.configManager.getGeneralConfiguration().getString("enabled"), true));
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

    public BrotherhoodManager getBrotherhoodManager() {
        return brotherhoodManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
