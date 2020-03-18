package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomerMapper {

    public static int saldo(String email) throws LoginSampleException {
        int saldo = 0;
        try{
            Connection con = Connector.connection();
            String sql = "select * from customers where email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                saldo = resultSet.getInt("saldo");
            }

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }
        return saldo;
    }

    public static void updateSaldo(String email, int sum) throws LoginSampleException {
        try{
            Connection con = Connector.connection();
            String sql = "UPDATE customers SET saldo = saldo-"+sum+" WHERE email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static ArrayList<Order> paidOrders(String email) throws LoginSampleException {
        /*
        todo fill up the list with paid orders
         */
        ArrayList<Order> savedOrders = new ArrayList<>();

        try{
            Connection con = Connector.connection();
            String sql = "join query";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Order order = new Order();

            }

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }

        return savedOrders;
    }

    public static HashMap<Cupcake, Integer> inCart (String email) throws LoginSampleException {
        /*
        todo make an Order where status in DB is inCart
         */
        HashMap<Cupcake, Integer> items= new HashMap<>();

        try{
            Connection con = Connector.connection();
            String sql = "SELECT orderdetails.bottom, orderdetails.topping, orderdetails.quantity\n" +
                    "FROM orderdetails\n" +
                    "left JOIN orders\n" +
                    "ON orders.orderID = orderdetails.orderID where status='inCart' and email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                String bottom = resultSet.getString("bottom");
                String topping = resultSet.getString("topping");
                int quantity = resultSet.getInt("quantity");
                Cupcake cupcake = new Cupcake(bottom, topping);
                cupcake.setPrice(cupcake.price());
                items.put(cupcake,quantity);
            }

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }

        return items;
    }





}


