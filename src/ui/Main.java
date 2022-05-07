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
		
		int sellPrice=0;
		System.out.println("Type the selling price for the vehicle");
		sellPrice=sc.nextInt();
		
		String brand;
		System.out.println("Type the brand of the vehicle");
		brand=sc.next();
		
		String vModel;
		System.out.println("Type the model of the vehicle");
		vModel=sc.next();
		
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
		
		int optionVehicle=0;
		System.out.println(
		"Please select an option to choose the kind of vehicle\n"+
		"(1) Car\n"+
		"(2) Bike\n"
		);
		optionVehicle=sc.nextInt();
		
		switch(optionVehicle){
		case 1:
			optionCar(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate);
			break;
		case 2:
			optionBike(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate);
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
	
	public void optionCar(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate){
	
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
		"(2) Electric Car\n"
		);
		carFuelOption=sc.nextInt();
		
		switch(carFuelOption){
		case 1:
			optionGas(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint);
			break;
		case 2:
			optionElectric(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint);
			break;
		default:
			System.out.println("Error, Not a valid option");
		}
	}
	
	
	public void optionGas(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint){
		
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
		
		double gConsumption=0;
		System.out.println("Type the car's gasoline consumption");
		gConsumption=sc.nextDouble();
		
		System.out.println(ds.addGasCar(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint, capacity, gasTypeOption, gConsumption));
	}
	
	public void optionElectric(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate, int cTypeOption, int doors, boolean tint){
		
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
		
		double bConsumption=0;
		System.out.println("Type the car's battery consumption");
		bConsumption=sc.nextDouble();
		
		System.out.println(ds.addElectricCar(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate, cTypeOption, doors, tint, chargerTypeOption, batteryDuration, bConsumption));
	}
	
	public void optionBike(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, int typeOption, String plate){
		
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
		
		double consumption=0;
		System.out.println("Type the bike's fuel consumption");
		consumption=sc.nextDouble();
		
		System.out.println(ds.addBike(basePrice, sellPrice, brand, vModel, cc, km, typeOption, plate, bikeTypeOption, gasCapacity, consumption));
	}
	
	public void showAllInfo(){
		System.out.println(ds.getInfo());
	}
}