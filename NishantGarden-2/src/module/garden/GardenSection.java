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
package module.garden;

import module.events.LowDayLight;
import module.events.PestAttack;
import module.events.PowerFailure;
import module.events.Rain;
import module.events.WaterCutOff;
import module.gui.GardenManagerController;
import module.heatingsystem.Heater;
import module.plants.CornPlant;
import module.plants.LemonsPlant;
import module.plants.Plants;
import module.plants.PotatoesPlant;
import module.plants.RicePlant;
import module.plants.VegitablesPlant;
import module.plants.WheatPlant;
import module.sensors.HumiditySensor;
import module.sensors.SoilSensor;
import module.sensors.TemperatureSensor;
import module.timesimulation.GardenTimer;
import module.wateringsystem.Sprinkler;

/**
 * @author nishant
 *
 */
public class GardenSection implements Runnable{
	
	private SectionConfiguration SectionConfig;
	private int SectionID;
	private Plants plants;
	private GardenManagerController GardenManagerScreen;
	private GardenTimer GlobalTime;
	
	private double waterNeed;
	private double waterLevel;
	private double hourlySupplySingle;
	private double hourlySupplyTotal;
	
	private int numberOfSprinklers;
	private int numberOfHeaters;
	
	private SoilSensor soilSensor;
	private TemperatureSensor tempSensor;
	private HumiditySensor humiditySensor;
	
	private Sprinkler sprinklers;
	private Heater heaters;
	
	private double threadRunFreq;
	private long lastTime;
	private long currentTime;
	private long days;
	private long lastDay;
	private long halfDays;
	private long lastHalfDay;
	
	private long hours;
	private long lastHour;
	private long minutes;
	
	private PestAttack pestEvent;
	private PowerFailure powerFailureEvent;
	private Rain rainEvent;
	private WaterCutOff waterCutOffEvent;
	private LowDayLight lowLightEvent;
	
	public GardenSection(SectionConfiguration incomingConfig, int id, 
							GardenManagerController screen, GardenTimer time) {
		this.SectionConfig = incomingConfig;
		this.SectionID = id;
		this.GardenManagerScreen = screen;
		this.GlobalTime = time;
		this.numberOfSprinklers = SectionConfig.getNumberOfSprinklers();
		this.numberOfHeaters = SectionConfig.getNumberOfHeaters();
		//System.out.println("GardenSection: " +"In contructor of " +SectionID );
		
		soilSensor = new SoilSensor(SectionConfig.getSoilWaterSensors());
		tempSensor = new TemperatureSensor(SectionConfig.getTempratureSensors());
		humiditySensor = new HumiditySensor(SectionConfig.getHumiditySensors());
		sprinklers = new Sprinkler();
		heaters = new Heater();
		
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("GardenSection: " +"Thread for Section " +this.SectionID +" created");
		
		setPlantType();
		
		if(isSprinklerNeeded()) {
			sprinklers.turnOnSprinkler();
			putTimestamp();
			System.out.println("GardenSection " +this.SectionID +": Sprinkler turned ON");
		}
		
		while(true) {
			currentTime = GlobalTime.getCurrentTime();
			//System.out.println("GardenSection " +this.SectionID +": time- " +currentTime);
			
			if(currentTime == lastTime) {
				//Do nothing	
			}
			// If time has changed, do tasks
			else {
				//Tasks that will be performed every minute
				
				calculateDaysHoursMinutes();
				
				soilSensor.decreaseWaterLevelBy(waterNeed/60);
				
				if(sprinklers.getSprinklerStatus()) {
					soilSensor.increaseWaterLevelBy(hourlySupplyTotal/60);
				}
				if(heaters.getHeaterStatus()) {
					tempSensor.heaterIncreaseTemp();
				}
				
				
				if(minutes%15 == 0) {
					//Do this every 15 min
					onOffSprinkler();
					PlantGrowth(92);
				}
				
				if(lastHour != hours) {
					//Do hourly tasks here
					//System.out.println("GardenSection " +this.SectionID +": hours- " +hours);
					naturalChangeTemperature();
					onOffHeater();
					
					lastHour = hours;
				}
				
				if(lastHalfDay != halfDays) {
					//Do twice a day tasks here
					//System.out.println("GardenSection " +this.SectionID +": Half Days- " +halfDays +" days " +days);
					
					lastHalfDay = halfDays;
				}
				
				if(lastDay != days) {
					//Do Daily tasks here
					//System.out.println("GardenSection " +this.SectionID +": Days- "  +days);
					System.out.println("GardenSection " +this.SectionID +": Days-"  +days +" growth-" +plants.getGrowth());
					
					soilSensor.decreaseFertilizerLevelBy(plants.getCurrentFertilizerNeed());
					lastDay = days;
				}
				
				if(days%3 == 0) {
					//Do tasks every three days here
					//System.out.println("GardenSection " +this.SectionID +": Days- "  +days);
					putFertilizers();
				}
			}
		
			lastTime = currentTime;
		}
		
	}
	
	private void PlantGrowth(double div) {
		double divisionFactor = div;
		
		if(waterLevel <0) {
			System.out.println("GardenSection " +this.SectionID +": Growth stopped due to low water");
			divisionFactor += 10000;
		}
		if(soilSensor.getFertilizerLevel() < 100) {
			System.out.println("GardenSection " +this.SectionID +": Growth slowed due to low fertilizer");
			divisionFactor += 10;
		}
		
		
	}
	
	private void setPlantType() {
		
		if(SectionConfig.getPlantType().equals("Wheat")) {
			plants = new WheatPlant();
			//System.out.println("GardenSection: " +"Water Need " +plants.getCurrentWaterNeed());
		}
		else if(SectionConfig.getPlantType().equals("Lemons")) {
			plants = new LemonsPlant();
		}
		else if(SectionConfig.getPlantType().equals("Vegitables")) {
			plants = new VegitablesPlant();
		}
		else if(SectionConfig.getPlantType().equals("Rice")) {
			plants = new RicePlant();
		}
		else if(SectionConfig.getPlantType().equals("Corn")) {
			plants = new CornPlant();
		}
		else if(SectionConfig.getPlantType().equals("Potatoes")) {
			plants = new PotatoesPlant();
		}
		//Default plant is Wheat
		//Error Proofing :P if something goes wrong, it will create wheat plants 
		else {
			plants = new WheatPlant();
		}
		
	}
	
	private boolean isSprinklerNeeded () {
		//Call this every min
		waterNeed = plants.getCurrentWaterNeed();
		waterLevel= soilSensor.getWaterLevel();
		
		hourlySupplySingle = sprinklers.getHourlySupply();
		hourlySupplyTotal = hourlySupplySingle * numberOfSprinklers;
		
		//System.out.println("GardenSection " +this.SectionID +" Water Level-" +waterLevel +" Water Need-" +waterNeed);
		
		if(waterNeed > waterLevel) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void calculateDaysHoursMinutes () {
		long numberOfMinutesSinceStart;
		
		numberOfMinutesSinceStart = currentTime;
		days = numberOfMinutesSinceStart / 1440;
		halfDays = numberOfMinutesSinceStart / 720;
		long temp1 = numberOfMinutesSinceStart % 1440;
		hours = temp1 / 60;
		minutes = temp1 % 60;
		
		//System.out.println("GardenSection: " +this.SectionID  +" TimeStamp: " +days +" days " 
		//						+hours +" hours " +minutes +" minutes");
		
	}
	
	private void putTimestamp() {
		System.out.println("GardenSection: " +this.SectionID  +" TimeStamp: " +days +" days " 
										+hours +" hours " +minutes +" minutes");
	}
	
	private void onOffSprinkler() {
		if(isSprinklerNeeded()) {
			sprinklers.turnOnSprinkler();
			putTimestamp();
			System.out.println("GardenSection " +this.SectionID +": Sprinkler turned ON");
		}
		else {
			if(sprinklers.getSprinklerStatus()) {
				sprinklers.turnOffSprinkler(); 
				putTimestamp();
				System.out.println("GardenSection " +this.SectionID +": Sprinkler turned OFF");
			}
		}
	}
	
	private void naturalChangeTemperature () {
		//Day time
		if(hours > 6 && hours < 18) {
			tempSensor.naturalIncreaseTemp();
		}
		//Night time
		else {
			tempSensor.naturalDecreaseTemp();
		}
	}
	
	private void onOffHeater() {
		if(tempSensor.getCurrentTemprature() < 40 && !heaters.getHeaterStatus()) {
			heaters.turnOnHeater();
			putTimestamp();
			System.out.println("GardenSection " +this.SectionID +": Heater turned ON" +" Temp-" +tempSensor.getCurrentTemprature());
		}
		if(tempSensor.getCurrentTemprature() > 70 && heaters.getHeaterStatus()) {
			heaters.turnOffHeater();
			putTimestamp();
			System.out.println("GardenSection " +this.SectionID +": Heater turned OFF" +" Temp-" +tempSensor.getCurrentTemprature());
		}
	}
	
	private void putFertilizers() {
		soilSensor.setFertilizerLevel(150);
		System.out.println("GardenSection " +this.SectionID +": Fertilizers put");
	}
}
