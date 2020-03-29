package FunctionLayer;

import java.util.ArrayList;

public class Customer {
    private String email;
    private String firstName;
    private String lastName;
    private ArrayList<Order> orders;
    private int saldo;

    public Customer(String email) {
        this.email = email;
        this.orders = new ArrayList<>();
        this.firstName=firstName;
        this.lastName=lastName;
        this.saldo=saldo;
    }

    public void add(Order order){
        orders.add(order);
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

}