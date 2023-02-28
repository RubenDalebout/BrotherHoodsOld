package io.github.rubendalebout.brotherhoods.classes;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Brotherhood {
    protected UUID id = UUID.randomUUID();
    protected String name;
    protected String displayName;

    protected List<UUID> players = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public Brotherhood(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Brotherhood setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<UUID> getPlayers() {
        return this.players;
    }

    public void addPlayer(UUID uuid) {
        if (!this.players.contains(uuid))
            this.players.add(uuid);
    }

    public void removePlayer(UUID uuid) {
        if (this.players.contains(uuid))
            this.players.remove(uuid);
    }
}
