package com.gildedrose.items;

import com.gildedrose.Item;

public class WrappedStockable extends Item implements Stockable {

    private static final int MAX_QUALLITY = 50;

    public WrappedStockable(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
        if(quality > MAX_QUALLITY) {
            this.quality = MAX_QUALLITY;
        }
    }


    @Override
    public void dailyUpdate() {
        this.sellIn = this.sellIn - 1;
        if((this.quality >= 1 ) && (
                this.sellIn >=0)) {
            this.quality = this.quality - 1;
        }
        if(this.sellIn < 0){
            if(this.quality > 2) {
                this.quality -= 2;
            }else{
                this.quality = 0 ;
            }
        }
    }
}
