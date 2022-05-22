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
	
	/**
	 * Constructor of Vehicle class
	 * @param basePrice
	 * @param brand
	 * @param vModel
	 * @param cc
	 * @param km
	 * @param type
	 * @param plate
	 */
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

	/**
	 * This method adds a Soat object to the first position of an array
	 * @param soat
	 */
	public void addSoat(Soat soat){
		documents[0]=soat;
	}
	
	/**
	 * This method adds a MechanicRevision object to the second position of an array
	 * @param mr
	 */
	public void addMechanicRevision(MechanicRevision mr){
		documents[1]=mr;
	}

	/**
	 * This method adds a PropertyCard object to the third position of an array
	 * @param pc
	 */
	public void addPropertyCard(PropertyCard pc){
		documents[2]=pc;
	}

	/**
	 * This method calculates a fine wether the documents are out of date
	 * @return
	 */
	public int documentFine(){
		int fine=0;
		for(int i=0; i<documents.length; i++){
			if(documents[i].getYear()<Dealership.ACTUAL_YEAR){
				fine+=500000;
				break;
			}
		}
		return fine;
	}

	/**
	 * This method prints information for all documents from a vehicle
	 * @return out: toString of all 3 documents
	 */
	public String printAllDocuments(){
		String out="";
		for(int i=0; i<documents.length; i++){
			out+=documents[i].toString();
		}
		return out;
	}
	
	/**
	 * This method allows all daughter classes to print their information differently
	 */
	public abstract String toString();

	/**
	 * This method allows all daughter classes to calculate the sale price in their own way
	 * @return
	 */
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