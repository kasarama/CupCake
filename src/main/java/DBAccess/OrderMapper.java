package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;

public class OrderMapper {
    public static void addToOrder(String bottom, String topping, int quantity, String sessionID) throws LoginSampleException {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO orderdetails (bottom, topping, quantity, status, sessionID) VALUES (?, ?, ?, ?,?)";
                System.out.println(SQL);
            //    PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setString(1, bottom);
                ps.setString(2, topping);
                ps.setInt(3, quantity);
                ps.setString(4, "inCart");
                ps.setString(5, sessionID);
                ps.executeUpdate();
                System.out.println("executed");


            } catch (SQLException |
                    ClassNotFoundException ex) {
                throw new LoginSampleException(ex.getMessage());
            }
    }

    public static Order newOrder (String email, Order order, String status) throws LoginSampleException {
        //todo

        try{
            Connection con = Connector.connection();
            String SQL = "Insert into orders (email, sum, status) values ('"+email+ "', "+order.getSum()+", '"+status+"')";
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
        order.setSum(order.sum());
        System.out.println("order filled up with cupcakes");
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

    public static void saveOrder(Order order, String sessionID, String email) throws LoginSampleException {
        //todo save order and order details in DB :
        // insert into orders,
        // delete from orderdetiles where given sessionID,
        // insert into orderdetiles,
        // change status from inCart to panding
        /*
        "insert into orders (email, sum) values ('"+email"+"',"+sum+")";
         */

        try{
            Connection con = Connector.connection();
            String orderSQL = "insert into orders (email, sum) values ('"+email+"',"+order.getSum()+")";
            String  deleteDetailsSQL= "delete from orderdetails where status='inCart' and sessionID='"+sessionID+"'";

            for (int i = 0; i < order.getProducts().keySet().size(); i++) {
                String bottom;
                String topping;
                int quantity;
                String  saveDetailsSQL= "select max(OrderID) as id from orders";

            }
            int orderID;
            PreparedStatement ps = con.prepareStatement(orderSQL);
            ResultSet resultSet = ps.executeQuery(orderSQL);
            while (resultSet.next()) {
                orderID = resultSet.getInt("id");
            }

        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }

    }



}
