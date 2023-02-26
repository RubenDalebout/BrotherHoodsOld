package io.github.rubendalebout.brotherhoods.classes;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Kingdom {
    protected UUID id = UUID.randomUUID();
    protected String name;
    protected String displayName;
    protected ItemStack displayItem;

    public UUID getId() {
        return id;
    }

    public Kingdom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Kingdom setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Kingdom setDisplayItem(ItemStack item) {
        this.displayItem = item;
        return this;
    }

    public ItemStack getDisplayItem() {
        return displayItem;
    }
}
