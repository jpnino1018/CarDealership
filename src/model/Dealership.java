package model;

import java.util.ArrayList;

public class Dealership{
	
	private ArrayList <Vehicle> vehicles;
	public static final int ACTUAL_YEAR=2022;

	public Dealership(){
		vehicles=new ArrayList <Vehicle>();
	}
	
	
	
	public int addGasCar(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint, int capacity, int gasTypeOption){

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
		
		Vehicle gasCar=new Gas(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint, capacity, gasType);
		vehicles.add(gasCar);
		return vehicles.indexOf(gasCar);
	}
	
	
	public int addElectricCar(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint, int chargerTypeOption, int batteryDuration){

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
		
		Vehicle electricCar=new Electric(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint, chargerType, batteryDuration);
		vehicles.add(electricCar);
		return vehicles.indexOf(electricCar);
	}
	
	public int addHybridCar(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint, int capacity, int gasTypeOption, int chargerTypeOption, int batteryDuration){
		
		Double sellPrice=basePrice;

		sellPrice+=basePrice*0.15;


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
		
		ChargerType chargerType=null;
		switch(chargerTypeOption){
			case 1:
				chargerType = ChargerType.REGULAR;
				break;
			case 2:
				chargerType = ChargerType.FAST;
				break;
		}
		
		Vehicle hybridCar=new Hybrid(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint, capacity, gasType, chargerType, batteryDuration);
		vehicles.add(hybridCar);
		return vehicles.indexOf(hybridCar);
	}
	
	public int addBike(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int bikeTypeOption, int gasCapacity){

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
		
		Vehicle bike=new Bike(basePrice, brand, vModel, cc, km, type, plate, bikeType, gasCapacity);
		vehicles.add(bike);
		return vehicles.indexOf(bike);
	}

	public void addSoatToVehicle(int index, double price, double coverage, int year) {
        Soat soat = new Soat(price, year, coverage);
        vehicles.get(index).addSoat(soat);    
    }
 
    public void addMechanicRevisionToVehicle(int index, double price, int year, double gasLevels) {
        MechanicRevision mr = new MechanicRevision(price, year, gasLevels);
        vehicles.get(index).addMechanicRevision(mr);
    }

    public void addPropertyCardToVehicle(int index, double price, int year) {
        PropertyCard pc = new PropertyCard(price, year);
        vehicles.get(index).addPropertyCard(pc);
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