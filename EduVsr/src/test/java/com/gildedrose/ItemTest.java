package com.gildedrose;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void decrease2AfterSellInPastTest() {
        //Given day past
        Item[] givenItems = new Item[]{new Item("General Item", 0, 5)};
        //action
        GildedRose app = new GildedRose(givenItems);
        app.updateQuality();
        //Expected
        Item[] expectedItems = new Item[]{new Item("General Item", -1, 3)};

        assertEquals(givenItems[0].toString().trim(),expectedItems[0].toString().trim());
    }

    @Test
    public void decrease1NormalTest(){
        //Given day past
        Item[] givenItems = new Item[]{new Item("General Item", 1, 5)};
        //action
        GildedRose app = new GildedRose(givenItems);
        app.updateQuality();
        //Expected
        Item[] expectedItems = new Item[]{new Item("General Item", 0, 4)};

        assertEquals(givenItems[0].toString().trim(),expectedItems[0].toString().trim());
    }
}
