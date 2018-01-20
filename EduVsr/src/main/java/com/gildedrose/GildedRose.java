package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {
            if(items[i] instanceof AgedBrie){
                ((AgedBrie)items[i]).dailyUpdate();
                continue;
            }else if (items[i] instanceof Backstage) {
                ((Backstage) items[i]).dailyUpdate();
                continue;
            }
            if (!(items[i] instanceof AgedBrie)
                    && !(items[i] instanceof Backstage)) {
                if (items[i].quality > 0) {
                    if (!(items[i] instanceof Sulfuras)) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    if (items[i] instanceof Backstage) {
                        if ((items[i].sellIn < 11 )&& (items[i].quality < 50)) {
                                items[i].quality = items[i].quality + 1;
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!(items[i] instanceof Sulfuras)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!(items[i] instanceof AgedBrie)) {
                    if (!(items[i] instanceof Backstage)) {
                        if (items[i].quality > 0) {
                            if (!(items[i] instanceof Sulfuras)) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0 ;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    public Item decrementarSellInSulfuras(Item item) {
        item.sellIn = item.sellIn - 1 ;
        return item;
    }
}
