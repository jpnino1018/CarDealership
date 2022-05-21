package model;

public class Gas extends Car implements GasConsumption{

	private int capacity;
	private GasType gasType;
	private double gConsumption;
	
	public Gas(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint, int capacity, GasType gasType){
		super(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint);
		this.capacity=capacity;
		this.gasType=gasType;
		gConsumption=calculateGasConsumption();
		sellPrice=calculateSellPrice();
	}
	
	@Override
	public double calculateGasConsumption(){
		double out=capacity*super.getCc()/150;
		return out;
	}

	@Override
	public double calculateSellPrice() {
		double sellPrice=basePrice;
		sellPrice+=documentFine();

		if(type==VehicleType.USED){
			sellPrice-=basePrice*0.1;
		}
		return sellPrice;
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