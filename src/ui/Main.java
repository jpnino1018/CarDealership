package ui;
import java.util.Scanner;
import model.Dealership;

public class Main{
	
	private Dealership ds;
	private Scanner sc;
	
	public Main(){
		ds=new Dealership();
		sc=new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		Main m = new Main();

		int option = 0;
		do{
			option= m.showMenu();
			m.executeOperation(option);
			
		}while (option!=0);
	}
	
	/**
	 * This method prints a menu and asks the user to choose an option
	 * @return option
	 */
	public int showMenu() {
		int option=0;

		System.out.println(
				"Please select an option.\n" +
				"(1) To register a vehicle\n" + 
				"(2) To calculate the price of certain vehicle\n" +
				"(3) To show vehicles by criteria\n"+
				"(4) To show documents of certain vehicle\n"+
				"(5) To show a map of the parking lot\n"+
				"(6) To show information regarding the parking lot\n"+
				"(0) To exit\n"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	/**
	 * This method functions as a ramification for different methods to operate
	 * @param operation
	 */
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
		    registerVehicle();	
			break;
		case 2:
			showSalePrice();
			break;
		case 3:
			showAllInfo();
			break;
		case 4:
			showAllDocuments();
			break;
		case 5:
			showParkingLot();
			break;
		case 6:
			showParkingInfo();
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
	/**
	 * This method registers information in common for all types of vehicles
	 */
	public void registerVehicle(){
		System.out.println("You're about to register a vehicle");
		
		int basePrice=0;
		System.out.println("Type the base price of the vehicle");
		basePrice=sc.nextInt();
		
		String brand;
		System.out.println("Type the brand of the vehicle");
		brand=sc.next();
		
		int cc=0;
		System.out.println("Type cylinder capacity of the vehicle");
		cc=sc.nextInt();
		
		double km=0;
		System.out.println("Type mileage of the vehicle");
		km=sc.nextDouble();
		
		String plate;
		System.out.println("Enter the vehicle's plate");
		plate=sc.next();
		
		int typeOption=0;
		System.out.println(
		"Please select an option to define the status of the vehicle\n"+
		"(1) New\n"+
		"(2) Used\n"
		);
		typeOption=sc.nextInt();

		int vModel=0;
		switch(typeOption){
			case 1:
				vModel=Dealership.ACTUAL_YEAR;
				break;
			case 2:
				System.out.println("Type the model of the vehicle");
				vModel=sc.nextInt();
				break;
		}
		int optionVehicle=0;
		System.out.println(
		"Please select an option to choose the kind of vehicle\n"+
		"(1) Car\n"+
		"(2) Bike\n"
		);
		optionVehicle=sc.nextInt();
		
		switch(optionVehicle){
		case 1:
			optionCar(basePrice, brand, vModel, cc, km, typeOption, plate);
			break;
		case 2:
			optionBike(basePrice, brand, vModel, cc, km, typeOption, plate);
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
	/**
	 * This method registers information in common for all CARS
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 */
	public void optionCar(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate){
	
		int cTypeOption=0;
		System.out.println(
			"Please select an option to define the type of car\n"+
			"(1) Sedan\n"+
			"(2) Truck\n"
			);
		cTypeOption=sc.nextInt();
		
		int doors=0;
		System.out.println("Enter the number of doors the car has");
		doors=sc.nextInt();
		
		int tintOption=0;
		System.out.println("Are the car windows tinted? 1 for YES and 2 for NO");
		tintOption=sc.nextInt();
		
		boolean tint=false;
		switch(tintOption){
		case 1:
			tint=true;
			break;
		case 2:
			tint=false;
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
		
		int carFuelOption=0;
		System.out.println(
		"Please select the car's fuel type\n"+
		"(1) Gasoline Car\n"+
		"(2) Electric Car\n"+
		"(3) Hybrid Car\n"
		);
		carFuelOption=sc.nextInt();
		
		switch(carFuelOption){
		case 1:
			optionGas(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint);
			break;
		case 2:
			optionElectric(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint);
			break;
		case 3:
			optionHybrid(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint);
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
	/**
	 * This method registers information for gas cars only
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
	 */
	public void optionGas(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint){
		
		int capacity=0;
		System.out.println("Type the car's fuel capacity");
		capacity=sc.nextInt();
		
		int gasTypeOption=0;
		System.out.println(
		"Please select an option according to the car's gasoline type\n"+
		"(1) Extra\n"+
		"(2) Regular\n"+
		"(3) Diesel\n"
		);
		gasTypeOption=sc.nextInt();
		
		int index=ds.addGasCar(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint, capacity, gasTypeOption);
		AddDocumentsByVehicleStatus(index, typeOption);
		System.out.println("\nVehicle with number of id ("+index+") has been added!\n");
	}
	
	/**
	 * This method registers information for electric cars only
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
	 */
	public void optionElectric(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint){
		
		int chargerTypeOption=0;
		System.out.println(
		"Please select an option according to the car's charger type\n"+
		"(1) Regular\n"+
		"(2) Fast\n"
		);
		chargerTypeOption=sc.nextInt();
		
		int batteryDuration=0;
		System.out.println("Type the car's battery duration");
		batteryDuration=sc.nextInt();
		
		int index=ds.addElectricCar(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint, chargerTypeOption, batteryDuration);
		AddDocumentsByVehicleStatus(index, typeOption);
		System.out.println("\nVehicle with number of id ("+index+") has been added!\n");
	}
	
	/**
	 * This method registers information for hybrid cars only
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
	 */
	public void optionHybrid(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint){
		
		int capacity=0;
		System.out.println("Type the car's fuel capacity");
		capacity=sc.nextInt();
		
		int gasTypeOption=0;
		System.out.println(
		"Please select an option according to the car's gasoline type\n"+
		"(1) Extra\n"+
		"(2) Regular\n"+
		"(3) Diesel\n"
		);
		gasTypeOption=sc.nextInt();
		
		int chargerTypeOption=0;
		System.out.println(
		"Please select an option according to the car's charger type\n"+
		"(1) Regular\n"+
		"(2) Fast\n"
		);
		chargerTypeOption=sc.nextInt();
		
		int batteryDuration=0;
		System.out.println("Type the car's battery duration");
		batteryDuration=sc.nextInt();
		
		int index=ds.addHybridCar(basePrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint, capacity, gasTypeOption, chargerTypeOption, batteryDuration);
		AddDocumentsByVehicleStatus(index, typeOption);
		System.out.println("\nVehicle with number of id ("+index+") has been added!\n");
	}
	
	/**
	 * This method register information for bikes only
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param typeOption
	 * @param plate
	 */
	public void optionBike(double basePrice, String brand, int vModel, int cc, double km, int typeOption, String plate){
		
		int bikeTypeOption=0;
		System.out.println(
		"Please select the bike's type\n"+
		"(1) Standard\n"+
		"(2) Sport\n"+
		"(3) Scooter\n"+
		"(4) Cross\n"
		);
		bikeTypeOption=sc.nextInt();
		
		int gasCapacity=0;
		System.out.println("Type the bike's fuel capacity");
		gasCapacity=sc.nextInt();
		
		int index=ds.addBike(basePrice, brand, vModel, cc, km, typeOption, plate, bikeTypeOption, gasCapacity);
		AddDocumentsByVehicleStatus(index, typeOption);
		System.out.println("\nVehicle with number of id ("+index+") has been added!\n");
	}

	/**
	 * This method registers information related with the SOAT
	 * @param index
	 */
	public void RegisterSoat(int index){
        System.out.println("\n***SOAT INFORMATION***\n");

        System.out.println("Type the SOAT's price");
        double price = sc.nextDouble();

        System.out.println("Type the SOAT's registered year");
        int year = sc.nextInt();

        System.out.println("Type the insurance coverage");
        double coverage=sc.nextDouble();

        ds.addSoatToVehicle(index, price, coverage, year);
    }

	/**
	 * This method registers information related with the Mechanic Revision
	 * @param index
	 */
    public void RegisterMechanicRevision(int index) {
        System.out.println("\n***TM REVISION INFORMATION***\n");

        System.out.println("Type the price of the mechanical revision");
        double price = sc.nextDouble();

        System.out.println("Type the revision's registered year");
        int year = sc.nextInt();

        System.out.println("Type the vehicle's gas levels");
        double gasLevel = sc.nextDouble();

        ds.addMechanicRevisionToVehicle(index, price, year, gasLevel);
    }

	/**
	 * This method registers information related with the Property Card
	 * @param index
	 */
    public void RegisterPropertyCard(int index) {
        System.out.println("\n***PROPERTY CARD***\n");

        System.out.println("Type the Property card's price");
        double price = sc.nextDouble();

        System.out.println("Type the Property Card's registered year");
        int year = sc.nextInt();

        ds.addPropertyCardToVehicle(index, price, year);
	}
	
	/**
	 * This method joins all methods to register documents depending on the vehicle status
	 * @param index
	 * @param statusOption
	 */
	public void AddDocumentsByVehicleStatus(int index, int statusOption){
		switch(statusOption){
			case 1:
				ds.addSoatToVehicle(index, 0.0, 0.0, Dealership.ACTUAL_YEAR);
				ds.addMechanicRevisionToVehicle(index, 0.0, Dealership.ACTUAL_YEAR, 0.0);
				ds.addPropertyCardToVehicle(index, 0.0, Dealership.ACTUAL_YEAR);
				break;
			case 2:
				RegisterSoat(index);
				RegisterMechanicRevision(index);
				RegisterPropertyCard(index);
				break;
		}
	}

	/**
	 * This method shows the sale price for a certain vehicle depending on it's id
	 */
	public void showSalePrice(){
		System.out.println("To calculate the vehicle's total price, please enter it's id");
		int index=sc.nextInt();
		 
		double price=ds.getSalePrice(index);
		if(price==-1){
			System.out.println("An error has ocurred");
		}else{
		System.out.println("The vehicle with id ("+index+") has a price of: $"+price);
		}
	}

	/**
	 * This method shows information for vehicles and displays some criteria for the user to choose from
	 */
	public void showAllInfo(){
		System.out.println("To show information on vehicles, please select any criteria\n"+
		"(1) Type of car\n"+
		"(2) Type of fuel\n"+
		"(3) Status\n");
		int criteria=sc.nextInt();

		int option=0;
		switch(criteria){
			case 1:
				System.out.println("Print information for:\n"+
				"(1) Gasoline\n"+
				"(2) Electric\n"+
				"(3) Hybrid\n"+
				"(4) Bike\n");
				option=sc.nextInt();
				System.out.println(ds.getTypeInfo(option));
				break;
			case 2:
				System.out.println("Print information for:\n"+
				"(1) Extra\n"+
				"(2) Regular\n"+
				"(3) Diesel\n");
				option=sc.nextInt();
				System.out.println(ds.getFuelInfo(option));
			case 3:
				System.out.println("Print information for:\n"+
				"(1) New\n"+
				"(2) Used\n");
				option=sc.nextInt();
				System.out.println(ds.getStatusInfo(option));
		};
	}

	/**
	 * This method shows information for all documents registered on certain vehicle
	 */
	public void showAllDocuments(){
		int index=0;
		System.out.println("Please enter the vehicle's id");
		index=sc.nextInt();
		System.out.println(ds.getDocumentsInformation(index));
	}

	/**
	 * This method shows a map of the parking lot
	 */
	public void showParkingLot(){
		System.out.println("***PARKING LOT MAP***\n"+ds.printParkingLot());
	}

	/**
	 * This method shows information from the parking lot depending on some criteria
	 */
	public void showParkingInfo(){
		System.out.println("Please choose any of the following criteria:\n"+
		"(1) Show all information on vehicles in parking from a certain model\n"+
		"(2) Show newest and oldest vehicle in parking\n"+
		"(3) Show percentage of occupation\n");

		int option=sc.nextInt();

		switch(option){
			case 1:
				System.out.println("Enter the model or year of the vehicle");
				int year=sc.nextInt();
				System.out.println(ds.showVehiclesInParkingLotByYear(year));
				break;
			case 2:
				System.out.println("****OLDEST VEHICLE****");
				System.out.println(ds.showOldestVehicleInParking());
				System.out.println("****NEWEST VEHICLE****");
				System.out.println(ds.showNewestVehicleInParking());
				break;
			case 3:
				System.out.println("****PERCENTAGE OF OCCUPATION****");
				System.out.println(ds.showParkingPercentage());
				break;
		}
	}
}