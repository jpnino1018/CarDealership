package model;

public class MechanicRevision extends Document{

    private double gasLevels;

    public MechanicRevision(double price, int year, double gasLevels) {
        super(price, year);
        this.setGasLevels(gasLevels);
        code=decodeImage();
    }

    @Override
    public String decodeImage(){
        code="";
        int r=1;

        for(int j=0; j<COLUMNS; j++){
            code+=""+image[0][j];
        }
        while (r!=ROWS){
            for(int j=COLUMNS-2; j>=0; j--){
                code+=""+image[r][j];
                r++;
            }
        }
        for(int j=1; j<COLUMNS; j++){
            code+=""+image[ROWS-1][j];
        }
        return code;
    }

    public double getGasLevels() {
        return gasLevels;
    }

    public void setGasLevels(double gasLevels){
        this.gasLevels = gasLevels;
    }

    @Override
    public String toString(){
        return "\n**TECHNICAL & MECHANICAL**\n"+
        super.toString()+
        "Gas Levels: "+gasLevels+"\n";
    }
}

    