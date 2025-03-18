package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredItemStrategy implements ItemUpdateStrategy {
    
    @Override
    public void update(Item item) {
        // the conjured items degrade twice as fast as normal items
        decreaseQuality(item);
        decreaseQuality(item);
        
        decreaseSellIn(item);
        
        if (item.sellIn < 0) {
            decreaseQuality(item);
            decreaseQuality(item);
        }
    }
}