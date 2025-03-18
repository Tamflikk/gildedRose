package com.gildedrose.strategy;

import com.gildedrose.Item;

public interface ItemUpdateStrategy {
    void update(Item item);
    
    default void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
    
    default void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }
    
    default void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
