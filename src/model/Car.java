package model;

public abstract class Car extends Vehicle{
	
	protected CarType cType;
	protected int doors;
	protected boolean tint;
	
	public Car(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate, CarType cType, int doors, boolean tint){
		super(basePrice, brand, vModel, cc, km, type, plate);
		this.cType=cType;
		this.doors=doors;
		this.tint=tint;
	}
}