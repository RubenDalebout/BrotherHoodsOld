package io.github.rubendalebout.brotherhoods.utils;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class Banner extends ItemStack {
    private static final HashMap<Integer, DyeColor> COLORS_MAP = new HashMap<Integer, DyeColor>() {{
        put(0, DyeColor.WHITE);
        put(1, DyeColor.ORANGE);
        put(2, DyeColor.MAGENTA);
        put(3, DyeColor.LIGHT_BLUE);
        put(4, DyeColor.YELLOW);
        put(5, DyeColor.LIME);
        put(6, DyeColor.PINK);
        put(7, DyeColor.GRAY);
        put(8, DyeColor.SILVER);
        put(9, DyeColor.CYAN);
        put(10, DyeColor.PURPLE);
        put(11, DyeColor.BLUE);
        put(12, DyeColor.BROWN);
        put(13, DyeColor.GREEN);
        put(14, DyeColor.RED);
        put(15, DyeColor.BLACK);
    }};

    public Banner(int colorCode) {
        super(Material.BANNER, 1, (short) 0);
        BannerMeta bannerMeta = (BannerMeta) this.getItemMeta();
        bannerMeta.addPattern(new Pattern(COLORS_MAP.get(colorCode), PatternType.BASE));
        this.setItemMeta(bannerMeta);

        ItemMeta itemMeta = this.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);

        this.setItemMeta(itemMeta);
    }
}