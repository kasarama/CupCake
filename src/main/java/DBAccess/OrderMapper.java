package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;

public class OrderMapper {
    public static void addToOrder(String bottom, String topping, int quantity) throws LoginSampleException {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO orderdetails (bottom, topping, quantity) VALUES (?, ?, ?)";
                System.out.println(SQL);
            //    PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement ps = con.prepareStatement(SQL);
                ps.setString(1, bottom);
                ps.setString(2, topping);
                ps.setInt(3, quantity);
                ps.executeUpdate();
                System.out.println("executed");


            } catch (SQLException |
                    ClassNotFoundException ex) {
                throw new LoginSampleException(ex.getMessage());
            }

    }

    public static void createOrder(Order order, String email) throws LoginSampleException {
        try{
            Connection con = Connector.connection();
            String SQL = "INSERT INTO order (e-mail, sum) VALUES (?, ?)";
            System.out.println(SQL);
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, email);
            ps.setInt(2, order.getSum());
            ps.executeUpdate();

        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
    }



}
