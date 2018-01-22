package com.gildedrose;

import com.gildedrose.items.Stockable;

class GildedRose {

    Stockable[] items;

    public GildedRose(Stockable[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Stockable stockable : items){
            stockable.dailyUpdate();
        }
    }

}
