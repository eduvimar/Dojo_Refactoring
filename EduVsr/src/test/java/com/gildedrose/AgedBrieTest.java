package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Stockable;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AgedBrieTest {
    @Test
    public void AgedBrieIncrementTest(){
        Stockable[] agedBrie = new Stockable[]{ new AgedBrie("",2,0)};
        GildedRose app = new GildedRose(agedBrie);
        app.updateQuality();
        assertEquals(new AgedBrie("" , 1 , 1).toString(), agedBrie[0].toString());
    }
}
