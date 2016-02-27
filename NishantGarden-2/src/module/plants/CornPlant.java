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
public class CornPlant extends Plants {
	
	public CornPlant() {
		this.currentGrowth = 1;
		this.growthRate = 2;
		//Default plant in a garden takes 100 days to grow from seed.
		this.maxArea = 0.5;
		//Default plant in a garden takes 0.25 sq.m area (i.e. 50 cm by 50 cm)
		this.waterIntakeFactor = 2;
		this.fertilizerIntakeFactor = 0.75;
	}

}
