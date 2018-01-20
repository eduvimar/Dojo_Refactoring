package com.gildedrose.items;

public class Backstage extends WrappedStockable {
    private static final String NAME = "Backstage";
    public Backstage(String name, int sellIn, int quality) {
        super(NAME + " " + name, sellIn, quality);
    }
    @Override
    public void dailyUpdate() {
        if(this.sellIn <=0){
            this.quality = 0;
        }else if(this.sellIn <= 5){
            this.quality  += 3;
        }else if(this.sellIn <= 10){
            this.quality += 2;
        }else {
            this.quality +=1;
        }
        this.sellIn -= 1;
    }
}
