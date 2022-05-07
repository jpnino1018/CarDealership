package model;

public class Electric extends Car{

	private ChargerType chargerType;
	private int batteryDuration;
	private double bConsumption;
	
	public Electric(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint, ChargerType chargerType, int batteryDuration, double bConsumption){
		super(basePrice, sellPrice, brand, vModel, cc, km, type, plate, cType, doors, tint);
		this.chargerType=chargerType;
		this.batteryDuration=batteryDuration;
		this.bConsumption=bConsumption;
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