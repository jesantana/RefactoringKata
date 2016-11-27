package com.gildedrose;

import java.util.HashMap;

import com.gildedrose.updaters.ItemQualityUpdater;


public class UpdaterMapper {

	private HashMap<String, ItemQualityUpdater> updatersMapping = new HashMap<String, ItemQualityUpdater>();
	
	
	public void addMapping(String name,ItemQualityUpdater updater){
		updatersMapping.put(name, updater);
	}
	
	public ItemQualityUpdater findMapping(String name){
		if(updatersMapping.containsKey(name)){
			return updatersMapping.get(name);
		}
		
		return new ItemQualityUpdater();
	}
}
