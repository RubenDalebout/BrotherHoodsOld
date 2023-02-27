package io.github.rubendalebout.brotherhoods.classes;

import java.util.UUID;

public class BrotherhoodPlayer {

    private UUID brotherhood;

    public UUID getBrotherhood() {
        return brotherhood;
    }

    public void setBrotherhood(UUID brotherhoodUUID) {
        this.brotherhood = brotherhoodUUID;
    }
}