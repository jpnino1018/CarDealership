package model;

public class Bike extends Vehicle implements GasConsumption{
	private BikeType bikeType;
	private int gasCapacity;
	private double consumption;
	
	/**Constructor for Bike class*/
	public Bike(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, BikeType bikeType, int gasCapacity){
		super(basePrice, brand, vModel, cc, km, type, plate);
		this.bikeType=bikeType;
		this.gasCapacity=gasCapacity;
		consumption=calculateGasConsumption();
	}
	
	@Override
	public double calculateGasConsumption(){
		double out=gasCapacity*super.getCc()/75;
		return out;
	}

	@Override
	public double calculateSellPrice() {
		double out=basePrice;
		out+=documentFine();
		out=basePrice*0.04;

		if(type==VehicleType.USED){
			out-=basePrice*0.02;
		}
		sellPrice=out;
		return out;
	}
	
	@Override
	public String toString(){
		return "***BIKE***\n"+
		"Base Price: $"+basePrice+"\n"+
		"Selling Price: $"+sellPrice+"\n"+
		"Brand: "+brand+"\n"+
		"Model: "+vModel+"\n"+
		"Cylinder Capacity: "+cc+"cc\n"+
		"Mileage: "+km+"km\n"+
		"Vehicle Type: "+type+"\n"+
		"Plate: "+plate+"\n"+
		"Bike Type: "+bikeType+"\n"+
		"Gas Capacity: "+gasCapacity+" gallons\n"+
		"Gas Consumption: "+consumption+" gal/km\n";
	}
}