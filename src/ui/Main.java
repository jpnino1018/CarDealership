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
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Please select an option.\n" +
				"(1) To register a vehicle\n" + 
				"(2) To show information on all vehicles\n" +
				"(0) To exit"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}

	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
		    registerVehicle();	
			break;
		case 2:
			showAllInfo();
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
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
	}
	
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
	}
	
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
	}
	
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
	}

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

    public void RegisterPropertyCard(int index) {
        System.out.println("\n***PROPERTY CARD***\n");

        System.out.println("Type the Property card's price");
        double price = sc.nextDouble();

        System.out.println("Type the Property Card's registered year");
        int year = sc.nextInt();

        ds.addPropertyCardToVehicle(index, price, year);
	}
	
	public void AddDocumentsByVehicleStatus(int index, int statusOption){
		switch(statusOption){
			case 1:
				ds.addSoatToVehicle(index, 0.0, 0.0, Dealership.ACTUAL_YEAR);
				break;
			case 2:
				RegisterSoat(index);
				RegisterMechanicRevision(index);
				RegisterPropertyCard(index);
				break;
		}
	}
	public void showAllInfo(){
		System.out.println(ds.getInfo());
	}
}