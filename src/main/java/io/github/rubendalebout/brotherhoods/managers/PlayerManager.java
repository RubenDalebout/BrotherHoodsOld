package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.BrotherhoodPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {
    private final BrotherHoods plugin;
    private Map<UUID, BrotherhoodPlayer> players = new HashMap<>();

    public PlayerManager(BrotherHoods plugin) {
        this.plugin = plugin;
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            addPlayer(player.getUniqueId());
        }
    }

    public Map<UUID, BrotherhoodPlayer> getPlayers() {
        return players;
    }

    public void addPlayer(UUID uuid) {
        this.players.put(uuid, new BrotherhoodPlayer());
    }

    public UUID getBrotherhood(UUID player) {
        return this.players.get(player).getBrotherhood();
    }
}
