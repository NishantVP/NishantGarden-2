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
public class LemonsPlant extends Plants {
	
	public LemonsPlant() {
		this.currentGrowth = 30;
		this.growthRate = 0.5;
		//Default plant in a garden takes 100 days to grow from seed.
		this.maxArea = 0.5;
		//Default plant in a garden takes 0.25 sq.m area (i.e. 50 cm by 50 cm)
		this.waterIntakeFactor = 8;
		this.fertilizerIntakeFactor = 0.75;
	}

}
