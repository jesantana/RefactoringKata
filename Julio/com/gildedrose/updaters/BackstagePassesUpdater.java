package com.gildedrose.updaters;

import com.gildedrose.Item;

public class BackstagePassesUpdater extends ItemQualityUpdater {

	@Override
	protected void updateQuality(Item current) {
		if(current.sellIn>10){
			current.quality+=1;
		}
		else if(current.sellIn>5){
			current.quality+=2;
		}
		else if(current.sellIn>0){
			current.quality+=3;
		}
		else{
			current.quality=QUALITY_MIN_VALUE;
		}
		
		current.quality = Math.min(QUALITY_MAX_VALUE, current.quality);
	}

}
