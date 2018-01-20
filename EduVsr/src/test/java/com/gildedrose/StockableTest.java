package com.gildedrose;

import com.gildedrose.items.Stockable;
import com.gildedrose.items.WrappedStockable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StockableTest {

    @Test
    public void decrease2AfterSellInPastTest() {
        //Given day past
        Stockable[] givenItems = new Stockable[]{new WrappedStockable("General Stockable", 0, 5)};
        //action
        GildedRose app = new GildedRose(givenItems);
        app.updateQuality();
        //Expected
        Stockable[] expectedItems = new Stockable[]{new WrappedStockable("General Stockable", -1, 3)};

        assertEquals(givenItems[0].toString().trim(),expectedItems[0].toString().trim());
    }

    @Test
    public void decrease1NormalTest(){
        //Given day past
        Stockable[] givenItems = new Stockable[]{new WrappedStockable("General Stockable", 1, 5)};
        //action
        GildedRose app = new GildedRose(givenItems);
        app.updateQuality();
        //Expected
        WrappedStockable[] expectedItems = new WrappedStockable[]{new WrappedStockable("General Stockable", 0, 4)};
        assertEquals(givenItems[0].toString().trim(),expectedItems[0].toString().trim());
    }
}
