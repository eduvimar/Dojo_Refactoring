package com.gildedrose.items;

public class AgedBrie extends WrappedStockable {
    private static final String AGED_BRIE = "Aged Brie";
    public AgedBrie(String name, int sellIn, int quality) {
        super( AGED_BRIE , sellIn, quality);
    }

    @Override
    public void dailyUpdate() {
        this.sellIn = this.sellIn -1;
        if(this.quality < 50) {
            this.quality = this.quality + 1;
        }
        if(this.sellIn <= 0){
            this.quality = 0;
        }
    }
}
