/**
 * COEN 275 OOAD - Individual Project
 * Automated Gardening System
 * 
 * By Nishant Phatangare (W1108022)
 */

/*
 * --About this <file>--
 * 
 */
package module.plants;

/**
 * @author nishant
 *
 */
public abstract class Plants {
	
	//--Variables--//
	protected double growth; 
	// Value of growth defines how much has plant grown.
	// growth = 0 means its a seed, growth = 1 means its fully grown plant
	
	protected double growthRate;
	// Rate at which this plant will grow each day
	
	protected double maxArea;
	// Each plant will take some space in garden. This variable defines maximum space that this plant will take.
	
	protected double waterIntakeFactor;
	// Each plant will take some space in garden. This variable defines maximum space that this plant will take.
	
	protected double fertilizerIntakeFactor;
	// Each plant will take some space in garden. This variable defines maximum space that this plant will take.
	
	
	//--Constructors--//
	protected Plants() {
		this.growth = 1;
		this.growthRate = 1;
		//Default plant in a garden takes 100 days to grow from seed.
		this.maxArea = 0.25;
		//Default plant in a garden takes 0.25 sq.m area (i.e. 50 cm by 50 cm)
		this.waterIntakeFactor = 1;
		this.fertilizerIntakeFactor = 0.5;
	}
	
	
	//--Getters and Setters--//
	public double getGrowth() {
		return this.growth;
	}
	public void setGrowth(double value) {
		this.growth = value;
	}
	
	public double getGrowthRate() {
		return this.growthRate;
	}
	public void setGrowthRate(double value) {
		this.growthRate = value;
	}
	
	public double getWaterIntakeFactor() {
		return this.waterIntakeFactor;
	}
	public void setWaterIntakeFactor(double value) {
		this.waterIntakeFactor = value;
	}
	
	public double getMaxArea() {
		return this.maxArea;
	}
	public void setMaxArea(double value) {
		this.maxArea = value;
	}
	
	public double getFertilizerIntakeFactor() {
		return this.fertilizerIntakeFactor;
	}
	public void setFertilizerIntakeFactor(double value) {
		this.maxArea = value;
	}
	
	//--Public Methods (Abstraction)--//
	//Length of the strip that this plant will take
	public double getMaxLength() {
		return Math.sqrt(this.maxArea);
		//We assume every plant takes area like a square shaped tile
	}
	
	public double getCurrentWaterNeed() {
		return waterIntakeFactor*growth;
	}
	public double getCurrentFertilizerNeed() {
		return fertilizerIntakeFactor*growth;
	}

}
