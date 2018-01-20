package com.gildedrose;

import com.gildedrose.items.Sulfuras;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SulfuraTest {
    @Test
    public void sulfuraLimitTest() {
        Sulfuras sulfura = new Sulfuras("sulfura" , 1 , 200);
        assertEquals(sulfura.toString().trim(),new Sulfuras("sulfura",1,80).toString().trim());
    }
}
