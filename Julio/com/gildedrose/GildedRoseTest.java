package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
    public void sellInAndQualityAreLoweredEveryDay() {
		GildedRose app = givenAProduct("product", 20, 20);
        
        app.updateQuality();
        
        assertEquals(app.items[0].name, "product");
        assertEquals(app.items[0].sellIn, 19);
        assertEquals(app.items[0].quality, 19);
    }
    
   
    @Test
    public void sellByDateHasPassedQualityDegradesTwiceAsFast() {
    	GildedRose app = givenAProduct("product", 0, 20);
        
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 18);
    }
    
   
    @Test
    public void qualityOfAnItemIsNeverNegative() {
    	GildedRose app = givenAProduct("product", 0, 0);
        
        app.updateQuality();
        
        assertTrue(app.items[0].quality >= 0);
    }
    
    @Test
    public void qualityOfAnItemIsNeverMoreThan50() {
    	GildedRose app = givenAProduct("Aged Brie", 10, 50);
        
        app.updateQuality();
        
        assertTrue(app.items[0].quality <= 50);
    }
    
    @Test
    public void agedBrieIncreasesInQualityTheOlderItGets() {
    	GildedRose app = givenAProduct("Aged Brie", 10, 2);
        
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 3);
    }
    
    @Test
    public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
    	GildedRose app = givenAProduct("Sulfuras, Hand of Ragnaros", 1, 1);
        
        app.updateQuality();
        
        assertEquals(app.items[0].sellIn, 1);
        assertEquals(app.items[0].quality, 1);
    }
    
    @Test
    public void backstagePassesIncreasesInQualityAsItsSellInValueApproaches() {
    	GildedRose app = givenAProduct("Backstage passes to a TAFKAL80ETC concert", 15, 40);
        
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 41);
    }
    
    @Test
    public void backstagePassesQualityIncreasesBy2WhenThereAre10DaysOrLess() {
    	GildedRose app = givenAProduct("Backstage passes to a TAFKAL80ETC concert", 10, 40);
        
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 42);
    }
    
    @Test
    public void backstagePassesQualityIncreasesBy3WhenThereAre5DaysOrLess() {
    	GildedRose app = givenAProduct("Backstage passes to a TAFKAL80ETC concert", 5, 40);
    	
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 43);
    }
    
    @Test
    public void backstagePassesQualityDropsTo0AfterTheConcert() {
    	GildedRose app = givenAProduct("Backstage passes to a TAFKAL80ETC concert", 0, 40);
        
        app.updateQuality();
        
        assertEquals(app.items[0].quality, 0);
    }
    
    private GildedRose givenAProduct(String name,int sellIn, int quality){
    	Item[] items = new Item[] { new Item(name, sellIn, quality) };
        return new GildedRose(items);
    }
}
