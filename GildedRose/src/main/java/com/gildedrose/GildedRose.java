package com.gildedrose;

class GildedRose {
    public static String AGED_BRIE = "Aged Brie";
    public static String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (SULFURAS.equals(item.name)) {
                continue;
            }
            if (AGED_BRIE.equals(item.name)) {
                handleAgedBrieUpdate(item);
                continue;
            }
            if (BACKSTAGE_PASSES.equals(item.name)) {
                handleBackstagePassesUpdate(item);
                continue;
            }

            handleNormalItem(item);
        }
    }

    private void handleNormalItem(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void handleAgedBrieUpdate(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void handleBackstagePassesUpdate(Item item) {

        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

}
