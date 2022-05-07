package model;

public abstract class Car extends Vehicle{
	
	protected CarType cType;
	protected int doors;
	protected boolean tint;
	
	public Car(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint){
		super(basePrice, sellPrice, brand, vModel, cc, km, type, plate);
		this.cType=cType;
		this.doors=doors;
		this.tint=tint;
	}
}