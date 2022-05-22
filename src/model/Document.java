package model;
import java.util.Random;

public abstract class Document{

    protected double price;
    protected int year;
    protected int[][] image;
    protected String code;
    protected static final int COLUMNS=4;
    protected static final int ROWS=4;

    /**
     * Constructor of Document Class
     * @param price
     * @param year
     */
    public Document(double price, int year){
        this.setPrice(price);
        this.setYear(year);
        image=new int[ROWS][COLUMNS];
        createImage();
    }

    /**
     * This method creates an image full of random numbers
     */
    public void createImage(){
        Random rand=new Random();
        for(int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                image[i][j]=rand.nextInt(100);
            }
        }
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int[][] getImage() {
        return image;
    }

    public void setImage(int[][] image) {
        this.image = image;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){
        return "Year: "+year+"\n"+
        "Price: $"+price+"\n"+
        printImage()+"\n"+
        "Code: "+code+"\n";
    }

    /**
     * This method prints the image
     * @return
     */
    public String printImage() {
        String out="";
        for (int i = 0; i<ROWS; i++) {
            for (int j = 0; j<COLUMNS; j++) {
                out += image[i][j] + " ";
            }
            out += "\n";
        }
        return out;
    }

    /**
     * This abstract method allows all daughter classes to decode image in their own way
     * @return
     */
    public abstract String decodeImage();
}