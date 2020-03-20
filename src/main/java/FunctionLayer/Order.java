package FunctionLayer;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
    private int id;
    private int sum;
    private HashMap<Cupcake, Integer> products;
    private String email;



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int sum(){
        int sum=0;
        for (Cupcake cupcake: products.keySet()) {
            sum=sum+(cupcake.getPrice()*getProducts().get(cupcake)); //price of one cupcake multiplied by quantity
            }
        return sum;
    }

    public void clear(){
        products.clear();
        setId(0);
        setSum(0);
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
    public int items() {
        int itemsNumber=0;
        for (Cupcake cupcake: products.keySet()) {
            int tmp = itemsNumber;
            itemsNumber = tmp+products.get(cupcake);
        }
        return itemsNumber;
    }


}
