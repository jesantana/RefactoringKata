package com.gildedrose.updaters;

import com.gildedrose.Item;

public class ItemQualityUpdater{
	
	protected static final int QUALITY_MIN_VALUE =0;
	protected static final int QUALITY_MAX_VALUE =50;

	public void update(Item current) {
		updateSellIn(current);
		
		updateQuality(current);
	}
	
	protected void updateSellIn(Item current){
		current.sellIn--;
	}
	
	protected void updateQuality(Item current){
		if(current.sellIn<=0){
			current.quality-=2;
		}
		else{
			current.quality-=1;
		}
		
		if(current.quality<QUALITY_MIN_VALUE){
			current.quality = QUALITY_MIN_VALUE;
		}
	}

}
