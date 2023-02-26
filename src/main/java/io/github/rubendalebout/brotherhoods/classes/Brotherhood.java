package io.github.rubendalebout.brotherhoods.classes;

import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Brotherhood {
    protected UUID id = UUID.randomUUID();
    protected String name;
    protected String displayName;
    protected ItemStack displayItem;

    protected int enteringLevel;

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

    public Brotherhood setDisplayItem(ItemStack item) {
        this.displayItem = item;
        return this;
    }

    public ItemStack getDisplayItem() {
        return displayItem;
    }

    public Brotherhood setEnteringLevel(int enteringLevel) {
        this.enteringLevel = enteringLevel;
        return this;
    }

    public int getEnteringLevel() {
        return enteringLevel;
    }

    public String getEnteringLevelText() {
        if (this.enteringLevel <= 0) return "&aOpen";
        if (this.enteringLevel == 1) return "&6Invite-only";
        if (this.enteringLevel >= 2) return "&4Closed";

        return "&cError";
    }
}
