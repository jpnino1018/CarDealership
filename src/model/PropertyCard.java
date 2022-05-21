package model;

public class PropertyCard extends Document{

    public PropertyCard(double price, int year) {
        super(price, year);
    }

    @Override
    public String decodeImage() {
        
        String out="";

        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                if((i+j)%2==0){
                    out+=""+image[i][j];
                }
            }
        }
        return out;
    }

    @Override
    public String toString(){
        return "**PROPERTY CARD**\n"+
        super.toString();
    }
}
