package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ItemUpdateStrategyFactory {
    
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured";
    
    public ItemUpdateStrategy createStrategy(Item item) {
        if (item.name.equals(AGED_BRIE)) {
            return new AgedBrieStrategy();
        } else if (item.name.equals(BACKSTAGE_PASSES)) {
            return new BackstagePassStrategy();
        } else if (item.name.equals(SULFURAS)) {
            return new SulfurasStrategy();
        } else if (item.name.startsWith(CONJURED)) {
            return new ConjuredItemStrategy();
        } else {
            return new StandardItemStrategy();
        }
    }
}
