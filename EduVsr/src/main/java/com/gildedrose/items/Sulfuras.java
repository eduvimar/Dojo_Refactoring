package com.gildedrose.items;


import com.gildedrose.Item;

public class Sulfuras extends Item implements Stockable {
    private static final String SULFURAS = "Sulfuras,";
    private static final int MAX_QUALITY = 80;
    public Sulfuras(String name, int sellIn, int quality) {
        super(SULFURAS + " " + name, sellIn, quality);
        if(quality > MAX_QUALITY){
            this.quality = 80;
        }else if( quality < 0){
            this.quality = 0;
        }
    }

    @Override
    public void dailyUpdate(){

    }
}
