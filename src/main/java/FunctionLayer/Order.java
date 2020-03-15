package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int id;
    private int sum;
    private HashMap<Cupcake, Integer> products;



    public Order() {
        this.id = id;
        this.sum = sum;
        this.products = new HashMap<>();
    }

    public void addCupcake (Cupcake cupcake, int quantity){
               if (products.containsKey(cupcake)){
            products.replace(cupcake, products.get(cupcake)+quantity);
        }else {products.put(cupcake, quantity);}
    }

    @Override
    public String toString() {
String cupcakes="";
        for (Cupcake c: products.keySet()) {
            String tmp = cupcakes;
            cupcakes= tmp + "\n" + c.getBottom() + "-"+c.getTopping()+ "-"+products.get(c);

        }
        return "Order: "  + cupcakes    ;
    }

    public int sum(){
        int sum=0;
        for (Cupcake cupcake: products.keySet()) {
            sum=sum+(cupcake.getPrice()*getProducts().get(cupcake)); //price of one cupcake multiplied by quantity
            }
        return sum;
    }

    public HashMap<Cupcake, Integer> getProducts() {
        return products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


}
