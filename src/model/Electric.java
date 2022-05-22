package model;

public class Electric extends Car implements BatteryConsumption{

	private ChargerType chargerType;
	private int batteryDuration;
	private double bConsumption;
	
	public Electric(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint, ChargerType chargerType, int batteryDuration){
		super(basePrice, brand, vModel, cc, km, type, plate, cType, doors, tint);
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		bConsumption=calculateBatteryConsumption();
	}
	
	@Override
	public double calculateBatteryConsumption(){
		double out=0;
		if(chargerType.equals(ChargerType.REGULAR)){
			out=(batteryDuration+18)*super.getCc()/100;
		}else if(chargerType.equals(ChargerType.FAST)){
			out=(batteryDuration+13)*super.getCc()/100;
		}
		return out;
	}

	@Override
	public double calculateSellPrice() {
		double out=basePrice;
		out+=documentFine();
		out+=basePrice*0.2;

		if(type==VehicleType.USED){
			out-=basePrice*0.1;
		}
		sellPrice=out;
		return out;
	}
	
	@Override
	public String toString(){
		return "***ELECTRIC CAR***\n"+
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
		"Charger Type: "+chargerType+"\n"+
		"Battery Duration: "+batteryDuration+" km\n"+
		"Battery Consumption: "+bConsumption+" kW/km\n";
	}
}