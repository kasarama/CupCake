package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;

public class OrderMapper {
    public static void addToOrder(String bottom, String topping, int quantity, String session) throws LoginSampleException {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO orderdetails (bottom, topping, quantity, status, session) VALUES (?, ?, ?, ?,?)";
                System.out.println(SQL);
            //    PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setString(1, bottom);
                ps.setString(2, topping);
                ps.setInt(3, quantity);
                ps.setString(4, "inCart");
                ps.setString(5, session);
                ps.executeUpdate();
                System.out.println("executed");


            } catch (SQLException |
                    ClassNotFoundException ex) {
                throw new LoginSampleException(ex.getMessage());
            }

    }
    public  static int cartNumber(String session) throws LoginSampleException {
        int number=0;
        try {
            Connection con = Connector.connection();
            String SQL = "select sum(quantity) as cartnumber from orderdetails where status='inCart' and session='"+session+"'";

            //    PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                number = resultSet.getInt("cartnumber");
            }

        } catch (SQLException |
                ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return number;

    }

    public static Order newOrder (String email, String session) throws LoginSampleException {
        Order order= new Order();
        try{
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM cupcake.orderdetails where session='"+session+"'";
            System.out.println(SQL);
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultSet =ps.executeQuery(SQL);
            while(resultSet.next()){
                String bottom = resultSet.getString("bottom");
                String topping = resultSet.getString("topping");
                int quantity =resultSet.getInt("quantity");
                Cupcake cupcake = new Cupcake(bottom, topping);
                cupcake.setPrice(cupcake.price());
                order.addCupcake(cupcake, quantity);
            }
        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
        order.setId(orderID());
        System.out.println("orderID: "+order.getId());
        order.setSum(order.sum());
        System.out.println("order sum: "+order.getSum());
        System.out.println(order.toString());
        return order;
    }

    public static int orderID () throws LoginSampleException {
        int id=0;
        try{
            Connection con = Connector.connection();
            String SQL = "select max(OrderID) as id from orders";
            PreparedStatement ps = con.prepareStatement(SQL);
            ResultSet resultSet = ps.executeQuery(SQL);
            while (resultSet.next()) {
                id = resultSet.getInt("id");
            }

        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
        return id+1;
    }



}
