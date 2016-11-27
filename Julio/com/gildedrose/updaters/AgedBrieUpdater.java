package com.gildedrose.updaters;

import com.gildedrose.Item;

public class AgedBrieUpdater extends ItemQualityUpdater{

	@Override
	protected void updateQuality(Item current) {
		if(current.quality<QUALITY_MAX_VALUE){
			current.quality++;
		}
	}

}
