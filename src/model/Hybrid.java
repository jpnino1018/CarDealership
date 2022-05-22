package model;

public class Hybrid extends Car implements GasConsumption, BatteryConsumption{

	private int capacity;
	private GasType gasType;
	private double gConsumption;
	private ChargerType chargerType;
	private int batteryDuration;
	private double bConsumption;
	
	public Hybrid(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint, int capacity, GasType gasType, ChargerType chargerType, int batteryDuration){
		super(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint);
		this.capacity=capacity;
		this.gasType=gasType;
		gConsumption=calculateGasConsumption();
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		bConsumption=calculateBatteryConsumption();
	}
	
	@Override
	public double calculateGasConsumption(){
		double out=capacity*super.getCc()/180;
		return out;
	}
	
	@Override
	public double calculateBatteryConsumption(){
		double out=0;
		if(chargerType.equals(ChargerType.REGULAR)){
			out=(batteryDuration+7)*super.getCc()/200;
		}else if(chargerType.equals(ChargerType.FAST)){
			out=batteryDuration*super.getCc()/200;
		}
		return out;
	}

	@Override
	public double calculateSellPrice() {
		double out=basePrice;
		out+=documentFine();
		out+=basePrice*0.15;

		if(type==VehicleType.USED){
			out-=basePrice*0.1;
		}
		sellPrice=out;
		return out;
	}
	
	@Override
	public String toString(){
		return "***HYBRID CAR***\n"+
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
		"Gas Consumption: "+gConsumption+" gal/km\n"+
		"Charger Type: "+chargerType+"\n"+
		"Battery Duration: "+batteryDuration+" km\n"+
		"Battery Consumption: "+bConsumption+" kW/km\n";
	}
}