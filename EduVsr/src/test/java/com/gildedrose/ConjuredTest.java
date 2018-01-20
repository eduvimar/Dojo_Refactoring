package com.gildedrose;

import com.gildedrose.items.Conjured;
import com.gildedrose.Item;
import com.gildedrose.items.Stockable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConjuredTest {

    @Test
    public void normalDecrementTest(){
        GildedRose griGildedRose = new GildedRose( new Stockable[]{new Conjured("",2,3)});
        griGildedRose.updateQuality();
        assertEquals(griGildedRose.items[0].toString().trim() ,new Conjured("",1,1).toString().trim());
    }

    @Test
    public void negativeSellInTest(){
        GildedRose griGildedRose = new GildedRose( new Stockable[]{new Conjured("",-1,5)});
        griGildedRose.updateQuality();
        assertEquals(griGildedRose.items[0].toString().trim() ,new Conjured("",-2,1).toString().trim());
    }

    @Test
    public void nonNegativeQuallityTest(){
        GildedRose griGildedRose = new GildedRose( new Stockable[]{new Conjured("",0,3)});
        griGildedRose.updateQuality();
        assertEquals(griGildedRose.items[0].toString().trim() ,new Conjured("",-1,0).toString().trim());
    }


}
