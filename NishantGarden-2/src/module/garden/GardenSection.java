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

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;

import module.events.LowDayLight;
import module.events.PestAttack;
import module.events.PowerFailure;
import module.events.Rain;
import module.events.WaterCutOff;
import module.gui.GardenManagerController;
import module.heatingsystem.Heater;
import module.logs.WriteLogs;
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
	private GardenManagerController GardenManagerScreen;
	private GardenTimer GlobalTime;
	
	private Plants plants;
	private String PlantTypeString;
	
	private double waterNeed;
	private double waterLevel;
	private double hourlySupplySingle;
	private double hourlySupplyTotal;
	
	private int numberOfSprinklers;
	private int numberOfHeaters;
	
	private SoilSensor soilSensor;
	private TemperatureSensor tempSensor;
	private HumiditySensor humiditySensor;
	private boolean isTempSensor;
	private boolean isSoilSensor;
	private boolean isHumiditySensor;
	
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
	
	private double growthDivisionFactor;
	
	private WriteLogs Log;
	private String LogMessage;
	
	public GardenSection(SectionConfiguration incomingConfig, int id, 
							GardenManagerController screen, GardenTimer time) {
		this.SectionConfig = incomingConfig;
		this.SectionID = id;
		this.GardenManagerScreen = screen;
		this.GlobalTime = time;
		this.PlantTypeString = SectionConfig.getPlantType();
		this.numberOfSprinklers = SectionConfig.getNumberOfSprinklers();
		this.numberOfHeaters = SectionConfig.getNumberOfHeaters();
		//System.out.println("GardenSection: " +"In contructor of " +SectionID );
		
		this.isTempSensor = SectionConfig.getTempratureSensors();
		this.isSoilSensor = SectionConfig.getSoilWaterSensors();
		this.isHumiditySensor = SectionConfig.getHumiditySensors();
		
		soilSensor = new SoilSensor(SectionConfig.getSoilWaterSensors());
		tempSensor = new TemperatureSensor(SectionConfig.getTempratureSensors());
		humiditySensor = new HumiditySensor(SectionConfig.getHumiditySensors());
		sprinklers = new Sprinkler();
		heaters = new Heater();
		
		//System.out.println("Sprinkler Status " +sprinklers.getSprinklerStatus());
		//System.out.println("Heater Status " +heaters.getHeaterStatus());
		
		pestEvent = new PestAttack();
		powerFailureEvent = new PowerFailure();
		rainEvent = new Rain();
		waterCutOffEvent = new WaterCutOff();
		lowLightEvent = new LowDayLight();
		
		Log = new WriteLogs(SectionID);
		this.growthDivisionFactor = 24;
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
		currentTime = GlobalTime.getCurrentTime();
		calculateDaysHoursMinutes();
		
		LogMessage ="Event" 			+","	+"TimeSinceStart"	+","
					+"Days" 			+"," 	+"Hours" 			+"," 	+"Minutes" 			+","
					+"AvgPlantGrowth"	+","
					+"SectionNumber" 	+"," 	+"PlantType" 		+"," 	+"NoOfSprinklers" 		+"," 	+"NoOfHeaters" +","
					+"TempSensors" 		+"," 	+"SoilSensors" 		+"," 	+"HumiditySensor"	+","
					+"WaterLevel"		+","	+"WaterNeed"		+","	+"SprinklerStatus"	+","
					+"CurrentTempera"	+","	+"HeaterStatus"		+","
					+"FertilizerLevel"	+","
					+"LowDayLight"		+","	+"LowLightSeverity" +","	
					+"PestAttack"		+","	+"PestSeverity"		+","	
					+"Power Failure"	+","	+"PowerOffTimeRemaining"	+","
					+"Rain"				+","	+"RainTimeRemaining"		+","
					+"WaterCutOff"		+","	+"WaterCutOffTimeRemaining"
					;
		
		try {
			Log.writeToFile(LogMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*if(isSprinklerNeeded()) {
			sprinklers.turnOnSprinkler();
			putTimestamp();
			//System.out.println("GardenSection " +this.SectionID +": Sprinkler turned ON");
		}*/
		
		WriteLogs("Section Created");
		
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
				
				
				if(minutes % 15 == 0) {
					//Do this every 15 min
					onOffSprinkler();
					String uiTimeString = "Days:" +days +" Hours:" +hours +" Minutes:" +minutes ; 
					GardenManagerScreen.updateTime(uiTimeString, this.SectionID);
				}
				
				if(lastHour != hours) {
					//Do hourly tasks here
					//System.out.println("GardenSection " +this.SectionID +": hours- " +hours);
					growthDivisionFactor = 24;
					
					naturalChangeTemperature();
					onOffHeater();
					
					EffectsDueToRandomEvents();
					PlantGrowth();
					
					lastHour = hours;
					
				}
				
				if(lastHalfDay != halfDays) {
					//Do twice a day tasks here
					//System.out.println("GardenSection " +this.SectionID +": Half Days- " +halfDays +" days " +days);
					UpdateGUI();
					
					lastHalfDay = halfDays;
				}
				
				if(lastDay != days) {
					//Do Daily tasks here
					WriteLogs("New Day");
					//System.out.println("GardenSection " +this.SectionID +": Days- "  +days);
					System.out.println("GardenSection " +this.SectionID +": Days-"  +days +" growth-" +plants.getGrowth());
					soilSensor.decreaseFertilizerLevelBy(plants.getCurrentFertilizerNeed()*24);
					
					putFertilizers();
					
					lastDay = days;
				}
				
				if(currentTime % 4320 == 0) {
					//Do tasks every three days here
					
					//System.out.println("GardenSection " +this.SectionID +": Days- "  +days);
					
					RandomEventMayHappen();
				}
			}
		
			lastTime = currentTime;
		}
		
	}
	
	private void UpdateGUI() {
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		String AvgPlantGrowth = numberFormat.format(plants.getGrowth());
		String RandomEvent = "";
		
		if(lowLightEvent.getEventStatus()) {
			RandomEvent += " Low Sunlight";
		}
		if(pestEvent.getEventStatus()) {
			RandomEvent += " Pest Attacks";
		}
		if(powerFailureEvent.getEventStatus()) {
			RandomEvent += " Power Failure";
		}
		if(rainEvent.getEventStatus()) {
			RandomEvent += " Rain";
		}
		if(waterCutOffEvent.getEventStatus()) {
			RandomEvent = " Water Cut Off";
		}
		
		
		String uiSectionStatusString = "Plant:" +PlantTypeString +", Average Growth: " +AvgPlantGrowth
									+", Random Event:" +RandomEvent ;
		GardenManagerScreen.updateLabel(uiSectionStatusString, this.SectionID);
	}
	
	private void RandomEventMayHappen () {
		Random rand = new Random();
		int randomNum = rand.nextInt(13);
		
		//putTimestamp();
		
		if(randomNum %2 == 0) {
			System.out.println("GardenSection " +this.SectionID +": No random event");
			WriteLogs("No Random Event Happened");
		}
		else if (randomNum == 3) {
			System.out.println("GardenSection " +this.SectionID +": Low Day Light");
			lowLightEvent.happens();
			WriteLogs("Low Day Light Event");
		}
		else if (randomNum == 5) {
			System.out.println("GardenSection " +this.SectionID +": Pest Attack");
			pestEvent.happens();
			WriteLogs("Pest Attacks");
		}
		else if (randomNum == 7) {
			System.out.println("GardenSection " +this.SectionID +": Power Failure");
			powerFailureEvent.happens();
			WriteLogs("Power Failure Occurs");
		}
		else if (randomNum == 9) {
			System.out.println("GardenSection " +this.SectionID +": Rain");
			rainEvent.happens();
			WriteLogs("Rain Starts");
		}
		else if (randomNum == 11) {
			System.out.println("GardenSection " +this.SectionID +": Water Cut Off");
			waterCutOffEvent.happens();
			WriteLogs("Water CutOff Occurs");
		}
		else {
			System.out.println("GardenSection " +this.SectionID +": No random event");
			WriteLogs("No Random Event");
		}
	}
	
	private void EffectsDueToRandomEvents() {
		
		if(lowLightEvent.getEventStatus()) {
			growthDivisionFactor += (lowLightEvent.getSeverity()/10);
			lowLightEvent.decreaseSeverity();
			WriteLogs("Plant Growth Slows due to Low Sunlight");
		}
		if(pestEvent.getEventStatus()) {
			growthDivisionFactor += (pestEvent.getSeverity()/10);
			pestEvent.decreaseSeverity();
			WriteLogs("Plant Growth Slows due to Pest Attack");
		}
		if(powerFailureEvent.getEventStatus()) {
			if(sprinklers.getSprinklerStatus()) {
				sprinklers.turnOffSprinkler();
				WriteLogs("Sprinklers off due to Power Failure");
			}
			if(heaters.getHeaterStatus()) {
				heaters.turnOffHeater();
				WriteLogs("Heaters off due to Power Failure");
			}
			powerFailureEvent.decreaseTimeReaming();
		}
		if(rainEvent.getEventStatus()) {
			if(sprinklers.getSprinklerStatus()) {
				sprinklers.turnOffSprinkler();
				WriteLogs("Sprinklers off because of Rain");
			}
			soilSensor.increaseWaterLevelBy(50);
			rainEvent.decreaseTimeReaming();
		}
		if(waterCutOffEvent.getEventStatus()) {
			if(sprinklers.getSprinklerStatus()) {
				sprinklers.turnOffSprinkler();
				WriteLogs("Sprinklers off due to Water CutOff");
			}
			waterCutOffEvent.decreaseTimeReaming();
		}
		
	}
	
	private void PlantGrowth() {
		
		if(waterLevel < 0) {
			//System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
			//System.out.println("GardenSection " +this.SectionID +": Growth stopped due to no water");
			growthDivisionFactor += 100;
			WriteLogs("Plant Growth Stopped due to No Water");
		}
		else if(waterLevel < 0.5*waterNeed) {
			//System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
			//System.out.println("GardenSection " +this.SectionID +": Growth slowed due to low water");
			growthDivisionFactor += 10;
			WriteLogs("Plant Growth slows due to Low Water");
		}
		else if(waterLevel > 25*waterNeed) {
			growthDivisionFactor += 5;
			//System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
			//System.out.println("GardenSection " +this.SectionID +": Growth slowed due to too much water");
			WriteLogs("Plant Growth slows due to Excess Water");
		}
		if(soilSensor.getFertilizerLevel() < plants.getCurrentFertilizerNeed()) {
			//System.out.println("GardenSection " +this.SectionID +": Growth slowed due to low fertilizer");
			//System.out.println("GardenSection " +this.SectionID +": Fertilizer need= " +plants.getCurrentFertilizerNeed() +"Fertilizer Level = " +soilSensor.getFertilizerLevel());
			growthDivisionFactor += 10;
			WriteLogs("Plant Growth slows due to Low Fertilizer");
		}
		plants.grows(growthDivisionFactor);
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
			if(waterLevel > 25*waterNeed) {
				
				//System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
				//System.out.println("GardenSection " +this.SectionID +" pumps used to suck too much water");
				
				soilSensor.setWaterLevel(12*waterNeed);
				WriteLogs("Pumps Suck Excess Water");
				//System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
			}
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
		
		if (powerFailureEvent.getEventStatus()) {
		//	System.out.println("GardenSection " +this.SectionID +": No Power, Can not turn on Sprinkler");
		}
		else if (waterCutOffEvent.getEventStatus()) {
			//System.out.println("GardenSection " +this.SectionID +": No Water, Can not turn on Sprinkler");
		}
		else if(!isSoilSensor) {
			if(hours >= 0 && hours < 2 && !sprinklers.getSprinklerStatus()) {
				sprinklers.turnOnSprinkler();
				WriteLogs("Sprinklers turned ON");
			}
			else if(hours > 2 && sprinklers.getSprinklerStatus()) {
				sprinklers.turnOffSprinkler();
				WriteLogs("Sprinklers turned OFF");
			}
		}
		else {
			if(isSprinklerNeeded()) {
				if(!sprinklers.getSprinklerStatus()) {
					sprinklers.turnOnSprinkler();
					WriteLogs("Sprinklers turned ON");
				}
				//putTimestamp();
				//System.out.println("GardenSection " +this.SectionID +": Sprinkler turned ON");
			//	System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
			}
			else {
				
				if(sprinklers.getSprinklerStatus()) {
					sprinklers.turnOffSprinkler();
					WriteLogs("Sprinklers turned OFF");
					//putTimestamp();
				//	System.out.println("GardenSection " +this.SectionID +": Water Level=" +waterLevel +" Water Need=" +waterNeed);
				//	System.out.println("GardenSection " +this.SectionID +": Sprinkler turned OFF");
				}
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
		if (powerFailureEvent.getEventStatus()) {
			//System.out.println("GardenSection " +this.SectionID +": No Power, Can not turn on Heaters");
		}
		else if(!isTempSensor) {
			if(hours >= 0 && hours < 6 && !heaters.getHeaterStatus()) {
				heaters.turnOnHeater();
				WriteLogs("Heaters turned ON");
			}
			else if(hours > 8 && heaters.getHeaterStatus()) {
				heaters.turnOffHeater();
				WriteLogs("Heaters turned OFF");
			}
		}
		else {
			if(tempSensor.getCurrentTemprature() < 40 && !heaters.getHeaterStatus()) {
				heaters.turnOnHeater();
				WriteLogs("Heaters turned ON");
				//putTimestamp();
				//System.out.println("GardenSection " +this.SectionID +": Heater turned ON" +" Temp-" +tempSensor.getCurrentTemprature());
			}
			if(tempSensor.getCurrentTemprature() > 70 && heaters.getHeaterStatus()) {
				heaters.turnOffHeater();
				WriteLogs("Heaters turned OFF");
				//putTimestamp();
				//System.out.println("GardenSection " +this.SectionID +": Heater turned OFF" +" Temp-" +tempSensor.getCurrentTemprature());
			}
		}
		
	}
	
	private void putFertilizers() {
		soilSensor.setFertilizerLevel(plants.getCurrentFertilizerNeed()*24);
		WriteLogs("Fertilizers Balanced");
		//System.out.println("GardenSection " +this.SectionID +": Fertilizers put");
	}
	
	private void WriteLogs(String event) {
		//LogMessage = "Section" +SectionID +"," +days +"," +hours +"," +minutes;
		CreateLogMessage();
		LogMessage = event +"," +LogMessage;
		try {
			Log.writeToFile(LogMessage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void CreateLogMessage() {
		
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		//System.out.println(numberFormat.format(number));
		String AvgPlantGrowth = numberFormat.format(plants.getGrowth());
		String WaterLevelString;
		String FertilizerLevelString;
		String TemperatureString;
		if(isSoilSensor){
			WaterLevelString = numberFormat.format(soilSensor.getWaterLevel());
			FertilizerLevelString = numberFormat.format(soilSensor.getFertilizerLevel());
		}
		else {
			WaterLevelString = "NA";
			FertilizerLevelString = "NA";
		}
		if(isTempSensor) {
			TemperatureString = numberFormat.format(tempSensor.getCurrentTemprature());
		}
		else {
			TemperatureString = "NA";
		}
		String WaterNeedString = numberFormat.format(plants.getCurrentWaterNeed());
		
		String SprinklerStatusString;
		if(sprinklers.getSprinklerStatus()) {
			SprinklerStatusString = "On";
		}
		else {
			SprinklerStatusString = "Off";
		}
		
		String HeaterStatusString;
		if(heaters.getHeaterStatus()) {
			HeaterStatusString = "On";
		}
		else {
			HeaterStatusString = "Off";
		}
		
		LogMessage =
				currentTime			+","
				+days 				+"," 	+hours 				+"," 	+minutes 				+","
				
				+AvgPlantGrowth		+","
				
				+SectionID 			+"," 	+PlantTypeString 	+"," 	+numberOfSprinklers 	+"," 	
				+numberOfHeaters 	+","
				+isTempSensor 		+"," 	+isSoilSensor 		+"," 	+isHumiditySensor		+","
				
				+WaterLevelString	+","	+WaterNeedString	+","	+SprinklerStatusString	+","
				+TemperatureString	+","	+HeaterStatusString	+","	+FertilizerLevelString	+","
				
				+lowLightEvent.getEventStatus()					+","	+lowLightEvent.getSeverity()			+","
				+pestEvent.getEventStatus()						+","	+pestEvent.getSeverity()				+","
				+powerFailureEvent.getEventStatus()				+","	+powerFailureEvent.getTimeRemaining()	+","
				+rainEvent.getEventStatus()						+","	+rainEvent.getTimeRemaining()			+","
				+waterCutOffEvent.getEventStatus()				+","	+waterCutOffEvent.getTimeRemaining()	+","
				;
	}
}
