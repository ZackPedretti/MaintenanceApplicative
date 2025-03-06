package com.gildedrose.items;

import static com.gildedrose.GildedRose.AGED_BRIE;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super(AGED_BRIE, sellIn, quality);
    }

    @Override
    public void update() {
        if (quality < 50) {
            quality = quality + 1;
        }

        sellIn = sellIn - 1;

        if (sellIn < 0 && quality < 50) {
            quality = quality + 1;
        }
    }
}
