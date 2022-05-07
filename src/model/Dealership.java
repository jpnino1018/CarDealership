package model;

import java.util.ArrayList;

public class Dealership{
	
	private ArrayList <Vehicle> vehicles;
	
	public Dealership(){
		vehicles=new ArrayList <Vehicle>();
	}
	
	public String addGasCar(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint, int capacity, int gasTypeOption, double gConsumption){
		
		VehicleType type=null;
		switch(typeOption){
			case 1:
				type = VehicleType.NEW;
				break;
			case 2:
				type = VehicleType.USED;
				break;
		}
		
		CarType cType=null;
		switch(cTypeOption){
			case 1:
				cType = CarType.SEDAN;
				break;
			case 2:
				cType = CarType.TRUCK;
				break;
		}
		
		GasType gasType=null;
		switch(gasTypeOption){
			case 1:
				gasType = GasType.EXTRA;
				break;
			case 2:
				gasType = GasType.REGULAR;
				break;
			case 3:
				gasType = GasType.DIESEL;
				break;
		}
		
		Vehicle gasCar=new Gas(basePrice, sellPrice, brand, vModel, cc, km, type, plate, cType, doors, tint, capacity, gasType, gConsumption);
		vehicles.add(gasCar);
		return "Gasoline Car has been added";
	}
	
	
	public String addElectricCar(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint, int chargerTypeOption, int batteryDuration, double bConsumption){
		
		VehicleType type=null;
		switch(typeOption){
			case 1:
				type = VehicleType.NEW;
				break;
			case 2:
				type = VehicleType.USED;
				break;
		}
		
		CarType cType=null;
		switch(cTypeOption){
			case 1:
				cType = CarType.SEDAN;
				break;
			case 2:
				cType = CarType.TRUCK;
				break;
		}
		
		ChargerType chargerType=null;
		switch(chargerTypeOption){
			case 1:
				chargerType = ChargerType.REGULAR;
				break;
			case 2:
				chargerType = ChargerType.FAST;
				break;
		}
		
		Vehicle electricCar=new Electric(basePrice, sellPrice, brand, vModel, cc, km, type, plate, cType, doors, tint, chargerType, batteryDuration, bConsumption);
		vehicles.add(electricCar);
		return "Electric Car has been added";
	}
	
	
	public String addBike(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate, int bikeTypeOption, int gasCapacity, double consumption){
		
		VehicleType type=null;
		switch(typeOption){
			case 1:
				type = VehicleType.NEW;
				break;
			case 2:
				type = VehicleType.USED;
				break;
		}
		
		BikeType bikeType=null;
		switch(bikeTypeOption){
			case 1:
				bikeType = BikeType.STANDARD;
				break;
			case 2:
				bikeType = BikeType.SPORT;
				break;
			case 3:
				bikeType = BikeType.SCOOTER;
				break;
			case 4:
				bikeType = BikeType.CROSS;
				break;
		}
		
		Vehicle bike=new Bike(basePrice, sellPrice, brand, vModel, cc, km, type, plate, bikeType, gasCapacity, consumption);
		vehicles.add(bike);
		return "Bike has been added";
	}
	
	public String getInfo(){
		
		String out="";
		
		for(int i=0; i<vehicles.size(); i++){
			if (vehicles.get(i) != null) {
				out+=((Vehicle)vehicles.get(i)).toString()+"\n";
			}
		}
		return out;
	}
}