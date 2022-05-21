package model;

public abstract class Vehicle{
	
	protected double basePrice;
	protected double sellPrice;
	protected String brand;
	protected int vModel;
	protected int cc;
	protected double km;
	protected VehicleType type;
	protected String plate;
	protected Document [] documents;
	
	public Vehicle(double basePrice, String brand, int vModel, int cc, double km, VehicleType type, String plate){
		this.basePrice=basePrice;
		this.brand=brand;
		this.vModel=vModel;
		this.cc=cc;
		this.km=km;
		this.type=type;
		this.plate=plate;
		documents=new Document[3];
	}
	public void addSoat(Soat soat){
		documents[0]=soat;
	}
	
	public void addMechanicRevision(MechanicRevision mr){
		documents[1]=mr;
	}

	public void addPropertyCard(PropertyCard pc){
		documents[2]=pc;
	}

	public int documentFine(){
		int fine=0;
		boolean flag=false;
		for(int i=0; i<documents.length && !flag; i++){
			if(documents[i].getYear()<Dealership.ACTUAL_YEAR){
				fine+=500000;
				flag=true;
			}
		}
		return fine;
	}

	public String printAllDocuments(){
		String out="";
		for(int i=0; i<documents.length; i++){
			out+=documents.toString();
		}
		return out;
	}
	
	public abstract String toString();

	public abstract double calculateSellPrice();
	
	public double getBasePrice(){
		return basePrice;
	}
	public double getSellPrice(){
		return sellPrice;
	}
	public String getBrand(){
		return brand;
	}
	public int getVModel(){
		return vModel;
	}
	public int getCc(){
		return cc;
	}
	public double getKm(){
		return km;
	}
	public VehicleType getType(){
		return type;
	}
	public String getPlate(){
		return plate;
	}
}