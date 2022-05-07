package model;

public abstract class Vehicle{
	
	protected double basePrice;
	protected double sellPrice;
	protected String brand;
	protected String vModel;
	protected int cc;
	protected double km;
	protected VehicleType type;
	protected String plate;
	
	public Vehicle(double basePrice, double sellPrice, String brand, String vModel, int cc, double km, VehicleType type, String plate){
		this.basePrice=basePrice;
		this.sellPrice=sellPrice;
		this.brand=brand;
		this.vModel=vModel;
		this.cc=cc;
		this.km=km;
		this.type=type;
		this.plate=plate;
	}
	
	public abstract String toString();
}