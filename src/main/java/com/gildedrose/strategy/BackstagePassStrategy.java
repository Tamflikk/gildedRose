package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassStrategy implements ItemUpdateStrategy {
    
    @Override
    public void update(Item item) {
        increaseQuality(item);
        
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        
        decreaseSellIn(item);
        
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}