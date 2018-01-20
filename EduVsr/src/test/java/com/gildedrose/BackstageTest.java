package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Backstage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstageTest {
    @Test
    public void backstageTest(){
        Backstage[] backstages = new Backstage[]{ new Backstage("passes to a TAFKAL80ETC concert",10,0)};
        GildedRose app = new GildedRose(backstages);
        app.updateQuality();
        assertEquals(new Backstage("passes to a TAFKAL80ETC concert" , 9 , 2).toString(), backstages[0].toString());
    }
}
