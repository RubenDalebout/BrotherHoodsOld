package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.Kingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KingdomManager {
    private final BrotherHoods plugin;
    protected List<Kingdom> kingdomList = new ArrayList<>();

    public KingdomManager(BrotherHoods plugin) {
        this.plugin = plugin;

        // load kingdoms from configuration
        this.loadConfigurationKingdoms();
    }

    private void loadConfigurationKingdoms() {
        ArrayList<Kingdom> kingdoms = new ArrayList<>();
        for(String key : plugin.getConfigManager().getKingdomConfiguration().getConfigurationSection("kingdoms").getKeys(false)) {
            String name = plugin.getConfigManager().getKingdomConfiguration().getString("kingdoms." + key + ".name");
            String formattedName = name.toLowerCase().replaceAll("[^a-zA-Z0-9-]", "").replace(" ", "-");

            Kingdom kingdom = new Kingdom(formattedName)
                    .setDisplayName(name);

            kingdoms.add(kingdom);
        }

        this.addKingdom(kingdoms.toArray(new Kingdom[0]));
    }

    public List<Kingdom> getKingdomList() {
        return kingdomList;
    }

    private void addKingdom(Kingdom... kingdoms) {
        for (Kingdom kingdom : kingdoms) {
            kingdomList.add(kingdom);
        }
    }

    private void removeKingdom(UUID uuid) {
        kingdomList.removeIf(kingdom -> kingdom.getId().equals(uuid));
    }
}
