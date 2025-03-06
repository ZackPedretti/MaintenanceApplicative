package com.gildedrose;

import com.gildedrose.items.Item;

public class GildedRose {
    public final static String AGED_BRIE = "Aged Brie";
    public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.update();
        }
    }
}
