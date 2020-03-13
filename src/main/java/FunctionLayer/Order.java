package FunctionLayer;

import java.util.ArrayList;

public class Order {
    private int id;
    private int sum;
    private ArrayList<Cupcake> products;



    public Order() {
        this.id = id;
        this.sum = sum;
        this.products = new ArrayList();
    }

    public void addCupcake (Cupcake cupcake){
        products.add(cupcake);
    }
    public int sum(){
        int sum=0;
        for (Cupcake cupcake:products) {
            sum=sum+cupcake.getPrice();

        }return sum;
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

    public ArrayList<Cupcake> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Cupcake> products) {
        this.products = products;
    }
}
