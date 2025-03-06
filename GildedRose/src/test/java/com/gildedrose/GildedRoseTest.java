package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /**
     * Quality of item should drop by 1 when it is updated
     */
    @Test
    @DisplayName("Update quality of item")
    void updateQualityOfItem() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Wooden sword", 10, 20)
        });
        app.updateQuality();
        assertEquals(19, app.items[0].quality);
    }

    /**
     * Sell-in day of item should drop by 1 when it is updated
     */
    @Test
    @DisplayName("Update sell-in day of item")
    void updateSellInOfItem() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Wooden sword", 10, 20)
        });
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    /**
     * Quality of item should drop by 2 when it is updated if its sell-in day is 0 or bellow
     */
    @Test
    @DisplayName("Update quality of item when sell-in day is passed")
    void updateQualityOfItemWhenSellInIsPassed() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Wooden sword", 0, 20)
        });
        app.updateQuality();
        assertEquals(18, app.items[0].quality);
    }

    /**
     * Sell-in day of item should still drop by 1 when it is updated if it is 0 or bellow
     */
    @Test
    @DisplayName("Update sell-in day when sell-in day is 0")
    void updateSellInOfItemWhenSellInIs0() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Wooden sword", 0, 20)
        });
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    /**
     * Quality of item should not be bellow 0
     */
    @Test
    @DisplayName("Update quality of item when it is 0")
    void updateQualityOfItemWhenItIs0() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Wooden sword", 10, 0)
        });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /**
     * Quality of aged brie raise drop by 1 when it is updated
     */
    @Test
    @DisplayName("Update quality of aged brie")
    void updateQualityOfAgedBrie() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Aged Brie", 10, 20)
        });
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    /**
     * Quality of item should not be above 50
     */
    @Test
    @DisplayName("Update quality of aged brie when it is 50")
    void updateQualityOfAgedBrieWhenItIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Aged Brie", 10, 50)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of Sulfuras should not be changed
     */
    @Test
    @DisplayName("Update quality of Sulfuras")
    void updateQualityOfSulfuras() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 10, 20)
        });
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
    }

    /**
     * Sell-in day of Sulfuras should not be changed
     */
    @Test
    @DisplayName("Update sell-in day of Sulfuras")
    void updateSellInOfSulfuras() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 10, 20)
        });
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    /**
     * Quality of backstage passes should raise by 1 when updated if its sell-in day is above 10
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is above 10")
    void updateQualityOfBackstagePassesWhenSellInIsAbove10() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20)
        });
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should raise by 2 when updated if its sell-in day is between 5 and 10
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 10")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And10() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)
        });
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should raise by 3 when updated if its sell-in day is between 5 and 0
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 0")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And0() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 20)
        });
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should drop to 0 when updated if its sell-in day is bellow 0
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is bellow 0")
    void updateQualityOfBackstagePassesWhenSellInIsBellow0() {
        GildedRose app = new GildedRose(new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20)
        });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
