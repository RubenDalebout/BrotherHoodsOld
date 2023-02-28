package io.github.rubendalebout.brotherhoods.classes;

import java.util.UUID;

public class BrotherhoodRank {
    protected UUID id = UUID.randomUUID();
    protected String name;
    protected String displayName;

    public UUID getId() {
        return id;
    }

    public BrotherhoodRank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BrotherhoodRank setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }
}
