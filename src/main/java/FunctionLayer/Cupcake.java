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
    private static int price(String bottom, String topping) {
        int priceB=0;
        int priceT=0;
        Map<String, Integer> priceList = new HashMap<>();


        return priceB + priceT;
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
