package com.gildedrose;

import com.gildedrose.updaters.AgedBrieUpdater;
import com.gildedrose.updaters.BackstagePassesUpdater;
import com.gildedrose.updaters.SulfurasUpdater;

class GildedRose {
    Item[] items;
    private UpdaterMapper mapper;

    public GildedRose(Item[] items) {
        this.items = items;
        this.mapper =new UpdaterMapper();
        
        this.mapper.addMapping("Aged Brie", new AgedBrieUpdater());
        this.mapper.addMapping("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        this.mapper.addMapping("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesUpdater());
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
        	mapper.findMapping(items[i].name).update(items[i]);
        }
    }
}
