package io.github.rubendalebout.brotherhoods.managers;

import io.github.rubendalebout.brotherhoods.BrotherHoods;
import io.github.rubendalebout.brotherhoods.classes.Brotherhood;
import io.github.rubendalebout.brotherhoods.classes.Kingdom;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BrotherhoodManager {
    private final BrotherHoods plugin;
    protected List<Brotherhood> brotherhoodList = new ArrayList<>();

    public BrotherhoodManager(BrotherHoods plugin) {
        this.plugin = plugin;
    }

    public List<Brotherhood> getBrotherhoodList() {
        return brotherhoodList;
    }

    public void addBrotherhood(Brotherhood... brotherhoods) {
        for (Brotherhood brotherhood : brotherhoods) {
            brotherhoodList.add(brotherhood);
        }
    }

    public void removeBrotherhood(UUID uuid) {
        brotherhoodList.removeIf(brotherhood -> brotherhood.getId().equals(uuid));
    }

    public Brotherhood getBrotherhood(UUID uuid, String name) {
        return brotherhoodList.stream()
                .filter(brotherhood -> uuid != null ? brotherhood.getId().equals(uuid)
                        : name != null ? brotherhood.getName().equalsIgnoreCase(name)
                        : false)
                .findFirst()
                .orElse(null);
    }

    public boolean hasBrotherhood(UUID player) {
        return brotherhoodList.stream().anyMatch(brotherhood -> brotherhood.getPlayers().contains(player));
    }
}
