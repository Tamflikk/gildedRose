package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieStrategy implements ItemUpdateStrategy {
    
    @Override
    public void update(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
        
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
