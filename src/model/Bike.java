package model;

public class Bike extends Vehicle{
	
	private BikeType bikeType;
	private int gasCapacity;
	private double consumption;
	
	public Bike(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, VehicleType type, String plate, BikeType bikeType, int gasCapacity, double consumption){
		super(basePrice, sellPrice, brand, vModel, cc, km, type, plate);
		this.bikeType=bikeType;
		this.gasCapacity=gasCapacity;
		this.consumption=consumption;
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