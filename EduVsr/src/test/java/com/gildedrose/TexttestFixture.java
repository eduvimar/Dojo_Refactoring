package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Stockable;
import com.gildedrose.items.Sulfuras;
import com.gildedrose.items.WrappedStockable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TexttestFixture {
    @Test
    public void allFlowTest() {
        //Given
        Stockable[] items = new Stockable[] {
                new WrappedStockable("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("", 2, 0), //
                new WrappedStockable("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Hand of Ragnaros", 0, 80), //
                new Sulfuras("Hand of Ragnaros", -1, 80),
                new Backstage("passes to a TAFKAL80ETC concert", 15, 20),
                new Backstage("passes to a TAFKAL80ETC concert", 10, 49),
                new Backstage("passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new WrappedStockable("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        //Expected
        com.gildedrose.Item[] itemsExpected = new com.gildedrose.Item[] {
                new com.gildedrose.Item("+5 Dexterity Vest", 9, 19), //
                new com.gildedrose.Item("Aged Brie", 1, 1), //
                new com.gildedrose.Item("Elixir of the Mongoose", 4, 6), //
                new com.gildedrose.Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new com.gildedrose.Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", 9, 51),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", 4, 52),
                // this conjured item does not work properly yet
                new com.gildedrose.Item("Conjured Mana Cake", 2, 5) };

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
        Stockable[] items = new Stockable[] {
                new WrappedStockable("+5 Dexterity Vest", 10, 20), //
                new AgedBrie("Aged Brie", 2, 0), //
                new WrappedStockable("Elixir of the Mongoose", 5, 7), //
                new Sulfuras("Hand of Ragnaros", 0, 80), //
                new Sulfuras("Hand of Ragnaros", -1, 80),
                new Backstage("passes to a TAFKAL80ETC concert", 15, 20),
                new Backstage("passes to a TAFKAL80ETC concert", 10, 49),
                new Backstage("passes to a TAFKAL80ETC concert", 5, 49)};
                // this conjured item does not work properly yet

        GildedRose app = new GildedRose(items);
        for(int days = 0 ; days < 11 ; days++){
            app.updateQuality();
        }
        //Expected
        com.gildedrose.Item[] itemsExpected = new com.gildedrose.Item[] {
                new com.gildedrose.Item("+5 Dexterity Vest", -1, 8), //
                new com.gildedrose.Item("Aged Brie", -9, 0), //
                new com.gildedrose.Item("Elixir of the Mongoose", -6, 0), //
                new com.gildedrose.Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new com.gildedrose.Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", 4, 38),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
                new com.gildedrose.Item("Backstage passes to a TAFKAL80ETC concert", -6, 0)};
                // this conjured item does not work properly yet;

        for (int arr = 0; arr< items.length ; arr++) {
            assertEquals(itemsExpected[arr].toString().trim(),items[arr].toString().trim());
        }
    }

}
