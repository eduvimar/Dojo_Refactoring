package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TexttestFixture {
    @Test
    public void allFlowTest() {
        //Given
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Hand of Ragnaros", 0, 80), //
                new Sulfuras("Hand of Ragnaros", -1, 80),
                new Backstage("passes to a TAFKAL80ETC concert", 15, 20),
                new Backstage("passes to a TAFKAL80ETC concert", 10, 49),
                new Backstage("passes to a TAFKAL80ETC concert", 5, 49),
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
        for(int days = 0 ; days < 10 ; days++){
                app.updateQuality();
        }
    }

    @Test
    public void allFlow11DaysTest() {
        //Given
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Hand of Ragnaros", 0, 80), //
                new Sulfuras("Hand of Ragnaros", -1, 80),
                new Backstage("passes to a TAFKAL80ETC concert", 15, 20),
                new Backstage("passes to a TAFKAL80ETC concert", 10, 49),
                new Backstage("passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        for(int days = 0 ; days < 11 ; days++){
            app.updateQuality();
        }
        //Expected
        Item[] itemsExpected = new Item[] {
                new Item("+5 Dexterity Vest", -1, 8), //
                new Item("Aged Brie", -9, 20), //
                new Item("Elixir of the Mongoose", -6, 0), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 4, 38),
                new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new Item("Backstage passes to a TAFKAL80ETC concert", -6, 0),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", -8, 0) };

        for (int arr = 0; arr< items.length ; arr++) {
            assertEquals(itemsExpected[arr].toString().trim(),items[arr].toString().trim());
        }
    }

}
