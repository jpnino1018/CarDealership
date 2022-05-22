package model;

public class ParkingLot{

    private static final int ROWS = 10;
    private static final int COLUMNS = 5;
    private Vehicle[][] parking;
    
    /**
     * Constructor of ParkingLot class
     */
    public ParkingLot(){
        parking = new Vehicle[ROWS][COLUMNS];
    }

    /**
     * This method assigns a vehicle their own spot in the parking lot
     * @param vehicle
     */
    public void addVehicleToParking(Vehicle vehicle){
        int row=0;
        if (vehicle.getType()==VehicleType.USED){
            if (vehicle.getVModel()==2014){
                row = findEmptyColumnPosition(0);
                if (row != -1) {
                    parking[row][0] = vehicle;
                }
            } else if (vehicle.getVModel() == 2013) {
                row = findEmptyColumnPosition(1);
                if (row != -1) {
                    parking[row][1] = vehicle;
                }
            } else if (vehicle.getVModel() == 2012) {
                row = findEmptyColumnPosition(2);
                if (row != -1) {
                    parking[row][2] = vehicle;
                }
            }else if (vehicle.getVModel() == 2011) {
                row = findEmptyColumnPosition(3);
                if (row != -1) {
                    parking[row][3] = vehicle;
                }
            }else if (vehicle.getVModel() < 2011) {
                row = findEmptyColumnPosition(4);
                if (row != -1) {
                    parking[row][4] = vehicle;
                }
            }
        }
    }

    /**
     * This method finds an empty space in a certain column
     * @param column
     * @return position: Empty row
     */
    public int findEmptyColumnPosition(int column){
        int position=-1;
        for (int i=0; i<parking.length; i++) {
            if (parking[i][column]==null) {
                position= i;
                break;
            }
        }
        return position;
    }

    /**
     * This method creates a map of the parking lot depending on it's occupation
     * @return
     */
    public String createParkingLot() {
        String out="";
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if(parking[i][j]==null){
                    out+="| O |";
                }else{
                    out+="| X |";
                }
            }
            out+="\n";
        }
        return out;
    }

    /**
     * This method prints the information on all vehicles with a certain model
     * @param year
     * @return out: toStrings of vehicles
     */
    public String printParkingLotByYear(int year){
        String out = "";
        switch (year){
            case 1:
                for (int i = 0; i < findEmptyColumnPosition(0); i++){
                    out += parking[i][0].toString() + "\n";
                }
                break;
            case 2:
                for (int i = 0; i < findEmptyColumnPosition(1); i++){
                    out += parking[i][1].toString() + "\n";
                }
                break;
            case 3:
                for (int i = 0; i < findEmptyColumnPosition(2); i++){
                    out += parking[i][2].toString() + "\n";
                }
                break;
            case 4:
                for (int i = 0; i < findEmptyColumnPosition(3); i++){
                    out += parking[i][3].toString() + "\n";
                }
                break;
            case 5:
                for (int i = 0; i < findEmptyColumnPosition(4); i++){
                    out += parking[i][4].toString() + "\n";
                }
                break;
        }
        return out;
    }

    /**
     * This method finds the newest model vehicle and sends it's information
     * @return out: toString of vehicle
     */
    public String findNewestVehicle(){

        String out = "No car found";
        int newestModel = 0;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if(parking[i][j]!=null){
                    if(parking[i][j].getVModel()>newestModel){
                    newestModel=parking[i][j].getVModel();
                    out=parking[i][j].toString();
                    }
                }
            }
        }
        return out;
    }

    /**
     * This method finds the oldest model vehicle and sends it's information
     * @return out: toString of vehicle
     */
    public String findOldestVehicle(){

        String out = "No car found";
        int oldestModel = Dealership.ACTUAL_YEAR;

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if(parking[i][j]!=null){
                    if(parking[i][j].getVModel()<oldestModel){
                        oldestModel=parking[i][j].getVModel();
                        out=parking[i][j].toString();
                    }
                }
            }
        }
        return out;
    }

    /**
     * This method calculates the percentage of cars registered in the parking lot
     * @return percentage of registered vehicles
     */
    public double calculateOccupationPercentage(){

        double counter = 0;

        for (int i=0; i<parking.length; i++) {
            for (int j=0; j<parking[0].length; j++) {
                if (parking[i][j]!=null) {
                    counter++;
                }
            }
        }
        return (counter/(ROWS*COLUMNS))*100;
    }

    /**
     * This method looks for a vehicle and returns a response
     * @param vehicle
     * @return out: Response according to the vehicle in question
     */
    public String findVehicle(Vehicle vehicle){

        String out = "";

        if (vehicle.getVModel()<=2014 && vehicle.getType()==VehicleType.USED){
            for (int i=0; i<parking.length; i++){
                for (int j=0; j<parking[0].length; j++){
                    if (parking[i][j] != null){
                        if (parking[i][j].equals(vehicle)){
                            out="This vehicle is currently registered in the parking lot";
                        }
                    }
                }
            }
        } else {
            out="This vehicle is not in the parking lot";
        }
        return out;
    }

}