package model;

import java.util.ArrayList;

public class Dealership{
	
	private ArrayList <Vehicle> vehicles;
	private ParkingLot parking;
	public static final int ACTUAL_YEAR=2022;

	/**Constructor for Dealership class*/
	public Dealership(){
		vehicles=new ArrayList <Vehicle>();
		parking=new ParkingLot();
	}
	
	/**This method creates a Gas object by using the parameters entered by the user
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 * @param cTypeOption
	 * @param doors
	 * @param tint
	 * @param capacity
	 * @param gasTypeOption
	 * @return Index to locate the vehice in the arraylist
	*/
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
		parking.addVehicleToParking(gasCar);
		return vehicles.indexOf(gasCar);
	}
	
	/**This method creates an Electric object by using the parameters entered by the user
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 * @param cTypeOption
	 * @param doors
	 * @param tint
	 * @param chargerTypeOption
	 * @param batteryDuration
	 * @return Index to locate the vehice in the arraylist
	*/
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
		parking.addVehicleToParking(electricCar);
		return vehicles.indexOf(electricCar);
	}
	
	/**This method creates a Hybrid object by using the parameters entered by the user
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 * @param cTypeOption
	 * @param doors
	 * @param tint
	 * @param capacity
	 * @param gasTypeOption
	 * @param chargerTypeOption
	 * @param batteryDuration
	 * @return Index to locate the vehice in the arraylist
	*/
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
		parking.addVehicleToParking(hybridCar);
		return vehicles.indexOf(hybridCar);
	}

	/**This method creates an Electric object by using the parameters entered by the user
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 * @param bikeTypeOption
	 * @param gasCapacity
	 * @return Index to locate the vehice in the arraylist
	*/
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
		parking.addVehicleToParking(bike);
		return vehicles.indexOf(bike);
	}

	/**
	 * This method adds the document Soat to a vehicle using it's position in the arraylist
	 * @param index
	 * @param price
	 * @param coverage
	 * @param year
	 */
	public void addSoatToVehicle(int index, double price, double coverage, int year) {
        Soat soat = new Soat(price, year, coverage);
        vehicles.get(index).addSoat(soat);    
    }

	/**
	 * This method adds the document MechanicRevision to a vehicle using it's position in the arraylist
	 * @param index
	 * @param price
	 * @param year
	 * @param gasLevels
	 */
    public void addMechanicRevisionToVehicle(int index, double price, int year, double gasLevels) {
        MechanicRevision mr = new MechanicRevision(price, year, gasLevels);
        vehicles.get(index).addMechanicRevision(mr);
    }

	/**
	 * This method adds the document PropertyCard to a vehicle using it's position in the arraylist
	 * @param index
	 * @param price
	 * @param year
	 */
    public void addPropertyCardToVehicle(int index, double price, int year) {
        PropertyCard pc = new PropertyCard(price, year);
        vehicles.get(index).addPropertyCard(pc);
    }
	
	/**
	 * This method calls for the result of the calculated price of the vehicle
	 * @param index
	 * @return price: Total price of the vehice
	 */
	public double getSalePrice(int index){
		double price=0;
		
		if(index>vehicles.size()){
			price=-1;
		}else{price=vehicles.get(index).calculateSellPrice();}
		return price;
	}

	/**
	 * This method calls for the method toString depending on the type of vehicle
	 * @param option
	 * @return	out: toString of the vehicle in question
	 */
	public String getTypeInfo(int option){
		
		String out="";

		switch(option){
			case 1:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Gas) {
						out+=((Gas)vehicles.get(i)).toString()+"\n";
					}
				}
				break;

			case 2:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Electric) {
						out+=((Electric)vehicles.get(i)).toString()+"\n";
					}
				}
				break;

			case 3:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Hybrid) {
						out+=((Hybrid)vehicles.get(i)).toString()+"\n";
					}
				}
				break;

			case 4:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Bike) {
						out+=((Bike)vehicles.get(i)).toString()+"\n";
					}
				}
				break;
			}
		return out;
	}

	/**
	 * This method calls for the method toString depending on the type of fuel of a Gas vehicle
	 * @param option
	 * @return out: toString of the vehicle in question
	 */
	public String getFuelInfo(int option){
		
		String out="";
		
		switch(option){
			case 1:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Gas) {
						if(((Gas)vehicles.get(i)).getGasType()==GasType.EXTRA){
						out+=((Gas)vehicles.get(i)).toString()+"\n";
						}
					}
				}
				break;

			case 2:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Gas) {
						if(((Gas)vehicles.get(i)).getGasType()==GasType.REGULAR){
							out+=((Gas)vehicles.get(i)).toString()+"\n";
						}
					}
				}
				break;

			case 3:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i) instanceof Gas) {
						if(((Gas)vehicles.get(i)).getGasType()==GasType.DIESEL){
						out+=((Gas)vehicles.get(i)).toString()+"\n";
						}
					}
				}
			break;
		}
		return out;
	}

	/**
	 * This method calls for the method toString depending on the status of any vehicle
	 * @param option
	 * @return out: toString of the vehicle in question
	 */
	public String getStatusInfo(int option){
		
		String out="";
		
		switch(option){
			case 1:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i).getType()==VehicleType.NEW) {
						out+=vehicles.get(i).toString()+"\n";
					}
				}
				break;

			case 2:
				for(int i=0; i<vehicles.size(); i++){
					if (vehicles.get(i).getType()==VehicleType.USED) {
						out+=vehicles.get(i).toString()+"\n";
					}
				}
				break;
		}
		return out;
	}

	/**
	 * This method receives the information of all documents of a certain vehicle and returns it
	 * @param index
	 * @return
	 */
	public String getDocumentsInformation(int index){
		return vehicles.get(index).printAllDocuments();
	}

	/**
	 * This method sends the vehicle's id to the parking lot for it to check if the vehicle is registered there
	 * @param index
	 * @return
	 */
	public String checkVehicleInParking(int index){
		return parking.findVehicle(vehicles.get(index));
	}

	/**
	 * This method sends the model of some vehicles to the parking lot for it to print their information
	 * @param year
	 * @return
	 */
	public String showVehiclesInParkingLotByYear(int year){
		return parking.printParkingLotByYear(year);
	}

	/**
	 * This mehod shows the newest model vehicle to the main class
	 * @return
	 */
	public String showNewestVehicleInParking(){
		return parking.findNewestVehicle();
	}

	/**
	 * This mehod shows the oldest model vehicle to the main class
	 * @return
	 */
	public String showOldestVehicleInParking(){
		return parking.findOldestVehicle();
	}

	/**
	 * This method shows the parking lot to the main class
	 * @return
	 */
	public String printParkingLot(){
		return parking.createParkingLot();
	}

	/**
	 * This method shows the percentage of occupation to the main class
	 * @return
	 */
	public double showParkingPercentage(){
		return parking.calculateOccupationPercentage();
	}


}