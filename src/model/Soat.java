package model;

public class Soat extends Document{

    private double coverage;

    public Soat(double price, int year, double coverage) {
        super(price, year);
        this.setCoverage(coverage);
        code=decodeImage();
    }

    @Override
    public String decodeImage(){
        code="";
        for(int i=0; i<ROWS; i++){
            code+=""+image[i][0];
        }
        for(int j=1; j<COLUMNS; j++){
            code+=""+image[ROWS-1][j];
        }
        return code;
    }
    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    @Override
    public String toString(){
        return "\n**SOAT**\n"+
        super.toString()+
        "Insurance Coverage: "+coverage+"\n";
    }

    
}
