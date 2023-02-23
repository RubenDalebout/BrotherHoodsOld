package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final BrotherHoods plugin;

    private FileConfiguration kingdomConfiguration;
    private File kingdomFile;

    private FileConfiguration generalConfiguration;
    private File generalFile;

    public ConfigManager(BrotherHoods plugin) {
        this.plugin = plugin;
        // General
        this.generalFile = new File(plugin.getDataFolder() + File.separator + "configurations", "configuration.yml");
        if (!generalFile.exists()) {
            createGeneralConfigIfNotExists();
        }
        this.generalConfiguration = YamlConfiguration.loadConfiguration(generalFile);
        // Kingdom
        this.kingdomFile = new File(plugin.getDataFolder() + File.separator + "configurations", "kingdoms.yml");
        if (!kingdomFile.exists()) {
            createKingdomConfigIfNotExists();
        }
        this.kingdomConfiguration = YamlConfiguration.loadConfiguration(kingdomFile);
    }

    // General configuration
    public FileConfiguration getGeneralConfiguration() {
        return this.generalConfiguration;
    }

    public void reloadGeneralConfiguration() {
        this.generalConfiguration = YamlConfiguration.loadConfiguration(generalFile);
    }

    public void saveGeneralConfiguration() {
        try {
            generalConfiguration.save(generalFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createGeneralConfigIfNotExists() {
        if (!generalFile.exists()) {
            generalFile.getParentFile().mkdirs();
            plugin.saveResource("configurations/configuration.yml", false);
        }
    }

    // Kingdom configuration

    public FileConfiguration getKingdomConfiguration() {
        return this.kingdomConfiguration;
    }

    public void reloadKingdomConfiguration() {
        this.kingdomConfiguration = YamlConfiguration.loadConfiguration(kingdomFile);
    }

    public void saveKingdomConfiguration() {
        try {
            kingdomConfiguration.save(kingdomFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createKingdomConfigIfNotExists() {
        if (!kingdomFile.exists()) {
            kingdomFile.getParentFile().mkdirs();
            plugin.saveResource("configurations/kingdoms.yml", false);
        }
    }
}
