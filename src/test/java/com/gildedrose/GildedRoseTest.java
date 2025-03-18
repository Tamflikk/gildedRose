package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    
    @Test
    void standardItemsDecreaseInQuality() {
        Item[] items = new Item[] { new Item("Standard Item", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    void standardItemsDecreaseInQualityTwiceAsFastAfterSellInExpires() {
        Item[] items = new Item[] { new Item("Standard Item", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void qualityShouldNeverBeNegative() {
        Item[] items = new Item[] { new Item("Standard Item", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void agedBrieIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void agedBrieIncreasesInQualityTwiceAsFastAfterSellInExpires() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void qualityShouldNeverExceed50() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void sulfurasNeverChanges() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(5, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void backstagePassesIncreasesInQuality() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 15, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(14, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void backstagePassesIncreasesByTwoWhenSellInIsLessThan11() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void backstagePassesIncreasesByThreeWhenSellInIsLessThan6() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    void backstagePassesQualityDropsToZeroAfterSellInExpires() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void conjuredItemsDegradeInQualityTwiceAsFast() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(4, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void conjuredItemsDegradeInQualityTwiceAsFastAfterSellInExpires() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }
}