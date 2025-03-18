package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StandardItemStrategy implements ItemUpdateStrategy {
    
    @Override
    public void update(Item item) {
        decreaseQuality(item);
        decreaseSellIn(item);
        
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
