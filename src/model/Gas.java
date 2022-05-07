package model;

public class Gas extends Car{

	private int capacity;
	private GasType gasType;
	private double gConsumption;
	
	public Gas(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint, int capacity, GasType gasType, double gConsumption){
		super(basePrice, sellPrice, brand, vModel, cc, km, type, plate, cType, doors, tint);
		this.capacity=capacity;
		this.gasType=gasType;
		this.gConsumption=gConsumption;
	}
	
	@Override
	public String toString(){
		return "***GASOLINE CAR***\n"+
		"Base Price: $"+basePrice+"\n"+
		"Selling Price: $"+sellPrice+"\n"+
		"Brand: "+brand+"\n"+
		"Model: "+vModel+"\n"+
		"Cylinder Capacity: "+cc+"cc\n"+
		"Mileage: "+km+"km\n"+
		"Vehicle Type: "+type+"\n"+
		"Plate: "+plate+"\n"+
		"Fuel Type: "+cType+"\n"+
		"Number of doors: "+doors+"\n"+
		"Tint: "+tint+"\n"+
		"Fuel Capacity: "+capacity+" Gallons\n"+
		"Gas Type: "+gasType+"\n"+
		"Gas Consumption: "+gConsumption+" gal/km\n";
	}
		
}