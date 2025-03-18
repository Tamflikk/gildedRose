package com.gildedrose;

import com.gildedrose.strategy.ItemUpdateStrategy;
import com.gildedrose.strategy.ItemUpdateStrategyFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        ItemUpdateStrategyFactory factory = new ItemUpdateStrategyFactory();
        
        for (Item item : items) {
            ItemUpdateStrategy strategy = factory.createStrategy(item);
            strategy.update(item);
        }
    }
}