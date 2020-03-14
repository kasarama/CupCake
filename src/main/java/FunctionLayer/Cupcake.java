package FunctionLayer;

import java.util.HashMap;
import java.util.Map;

public class Cupcake {
    private String bottom;
    private String topping;
    private int price;

    public Cupcake(String bottom, String topping) {
        this.price = price;
        this.bottom = bottom;
        this.topping = topping;
    }

    public int price (String bottom, String topping) {
        int bPrice=0;
        int tPrice=0;

        switch (bottom){
            case "Chocolate" :
            case "Vanilla":
            case "Nutmeg":
                bPrice=5;
                break;
            case "Pistacio":
                bPrice=6;
                break;
            case "Almond":
                bPrice=7;
                break;
            default:
                System.out.println("Wrong componentName");}

        switch (topping){
            case "Chocolate":
            case "Blueberry":
            case "Rasberry":
                tPrice=5;
                break;
            case "Crispy":
            case "Strawberry":
                tPrice=6;
                break;
            case "RumRaisin":
                tPrice=7;
                break;
            case "Orange":
            case "Lemon":
                tPrice=8;
                break;
            case"BlueCheese":
                tPrice=9;
                break;
            default:
                System.out.println("Wrong componentName");}

        return bPrice+tPrice;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
