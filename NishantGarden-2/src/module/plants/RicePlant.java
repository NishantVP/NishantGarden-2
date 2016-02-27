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
public class RicePlant extends Plants {
	
	public RicePlant() {
		this.currentGrowth = 2;
		this.growthRate = 2;
		//Default plant in a garden takes 100 days to grow from seed.
		this.maxArea = 0.25;
		//Default plant in a garden takes 0.25 sq.m area (i.e. 50 cm by 50 cm)
		this.waterIntakeFactor = 5;
		this.fertilizerIntakeFactor = 0.5;
	}

}
