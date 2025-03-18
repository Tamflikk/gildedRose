package com.gildedrose;

public class Main {
    public static void main(String[] args) {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Conjured Mana Cake", 3, 6)
        };

        GildedRose app = new GildedRose(items);

        System.out.println("Day 0");
        printItems(items);

        //itarate 5 days
        for (int i = 1; i <= 5; i++) {
            System.out.println("Día " + i);
            app.updateQuality();
            printItems(items);
        }
    }

    private static void printItems(Item[] items) {
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("---------------------");
    }
}

