package com.gildedrose.items;

public class Conjured extends WrappedStockable {


    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void dailyUpdate() {
        this.sellIn = this.sellIn - 1;
        if( this.sellIn == 0){
            this.quality = 0;
        }
        if( this.sellIn > 0){
            this.quality -=2;
        }
        if(this.sellIn < 0 ){
            this.quality -= 4;
        }
        if(this.quality < 0 ){
            this.quality =0;
        }
    }
}
