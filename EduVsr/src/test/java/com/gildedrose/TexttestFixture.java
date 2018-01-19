package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TexttestFixture {
    @Test
    public void allFlowTest() {
        //Given
        int daysTest = 1;
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //Expected
        Item[] itemsExpected = new Item[] {
                new Item("+5 Dexterity Vest", 9, 19), //
                new Item("Aged Brie", 1, 1), //
                new Item("Elixir of the Mongoose", 4, 6), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 2, 5) };

            for (int arr = 0; arr< items.length ; arr++) {
                assertEquals(itemsExpected[arr].toString().trim(),items[arr].toString().trim());
            }

    }
}
