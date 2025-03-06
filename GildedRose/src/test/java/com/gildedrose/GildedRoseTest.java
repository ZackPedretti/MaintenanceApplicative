package com.gildedrose;

import com.gildedrose.items.*;
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
                new NormalItem("Wooden sword", 10, 20)
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
                new NormalItem("Wooden sword", 10, 20)
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
                new NormalItem("Wooden sword", 0, 20)
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
                new NormalItem("Wooden sword", 0, 20)
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
                new NormalItem("Wooden sword", 10, 0)
        });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /**
     * Quality of item should not be bellow 0
     */
    @Test
    @DisplayName("Update quality of item when it is 0 and sell-in day is passed")
    void updateQualityOfItemWhenItIs0AndSellInDayIsPassed() {
        GildedRose app = new GildedRose(new Item[]{
                new NormalItem("Wooden sword", -1, 0)
        });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /**
     * Quality of aged brie should raise by 1 when it is updated
     */
    @Test
    @DisplayName("Update quality of aged brie")
    void updateQualityOfAgedBrie() {
        GildedRose app = new GildedRose(new Item[]{
                new AgedBrie(10, 20)
        });
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    /**
     * Quality of aged brie should raise by 2 when it is updated and when sell-in day is negative
     */
    @Test
    @DisplayName("Update quality of aged brie with sell-in negative")
    void updateQualityOfAgedBrieSellInNegative() {
        GildedRose app = new GildedRose(new Item[]{
                new AgedBrie(-1, 20)
        });
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    /**
     * Quality of aged brie should not change when it is updated and when sell-in day is negative and quality is 50
     */
    @Test
    @DisplayName("Update quality of aged brie with sell-in negative")
    void updateQualityOfAgedBrieSellInNegativeAndQualityIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new AgedBrie(-1, 50)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of item should not be above 50
     */
    @Test
    @DisplayName("Update quality of aged brie when it is 50")
    void updateQualityOfAgedBrieWhenItIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new AgedBrie(10, 50)
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
                new Sulfuras(10, 20)
        });
        app.updateQuality();
        assertEquals(20, app.items[0].quality);
    }

    /**
     * Quality of Sulfuras should not be changed
     */
    @Test
    @DisplayName("Update quality of Sulfuras when quality is 0 and sell-in day is passed")
    void updateQualityOfSulfurasSellInDayIsPassed() {
        GildedRose app = new GildedRose(new Item[]{
                new Sulfuras(-1, 20)
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
                new Sulfuras(10, 20)
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
                new BackstagePasses(11, 20)
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
                new BackstagePasses(10, 20)
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
                new BackstagePasses(3, 20)
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
                new BackstagePasses(0, 20)
        });
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not change if it is 50
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is above 10 and quality is 50")
    void updateQualityOfBackstagePassesWhenSellInIsAbove10AndQualityIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(11, 50)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not change if it is 50
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 10 and quality is 50")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And10AndQualityIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(6, 50)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not change if it is 50
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 0 and quality is 50")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And0AndQualityIs50() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(4, 50)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not go above 50 if it goes up by 2 and quality is 49
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 10 and quality is 49")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And10AndQualityIs49() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(6, 49)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not go above 50 if it goes up by 3 and quality is 49
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 0 and quality is 49")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And0AndQualityIs49() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(4, 49)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    /**
     * Quality of backstage passes should not go above 50 if it goes up by 3 and quality is 48
     */
    @Test
    @DisplayName("Update quality of backstage passes when sell-in day is between 5 and 0 and quality is 48")
    void updateQualityOfBackstagePassesWhenSellInIsBetween5And0AndQualityIs48() {
        GildedRose app = new GildedRose(new Item[]{
                new BackstagePasses(4, 48)
        });
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}
