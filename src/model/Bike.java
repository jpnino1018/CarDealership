package model;

public class Bike extends Vehicle implements GasConsumption{
	
	private BikeType bikeType;
	private int gasCapacity;
	private double consumption;
	
	public Bike(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, BikeType bikeType, int gasCapacity){
		super(basePrice, brand, vModel, cc, km, type, plate);
		this.bikeType=bikeType;
		this.gasCapacity=gasCapacity;
		consumption=calculateGasConsumption();
		sellPrice=calculateSellPrice();
	}
	
	@Override
	public double calculateGasConsumption(){
		double out=gasCapacity*super.getCc()/75;
		return out;
	}

	@Override
	public double calculateSellPrice() {
		double sellPrice=basePrice;
		sellPrice+=documentFine();
		sellPrice+=basePrice*0.04;

		if(type==VehicleType.USED){
			sellPrice-=basePrice*0.02;
		}
		return sellPrice;
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