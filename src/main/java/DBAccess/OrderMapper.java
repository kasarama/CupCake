package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;

public class OrderMapper {


    public static void newOrder (String email, Order order, String status) throws LoginSampleException {
        //todo Save Order in order, read inserted OrderID, save orderdetails (Cupcakes) of that order

        int orderID=0;
        try{
            Connection con = Connector.connection();
            String sqlSaveOrder = "Insert into orders (email, sum, status) values ('"+email+ "', "+order.getSum()+", '"+status+"')";
            PreparedStatement ps = con.prepareStatement(sqlSaveOrder);
            ps.executeUpdate(sqlSaveOrder);

            String sqlOrderID="select LAST_INSERT_ID() as orderID";
            ps = con.prepareStatement(sqlOrderID);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                orderID= resultSet.getInt("orderID");
            }

            for (Cupcake cupcake: order.getProducts().keySet()) {
                String bottom = cupcake.getBottom();
                String topping = cupcake.getTopping();
                int quantity = order.getProducts().get(cupcake);
                String sqlSaveDetails =  "Insert into orderdetails (orderID, bottom, topping, quantity, status) values " +
                        "( "+orderID+", '"+bottom+"', '"+topping+"', "+quantity+", '"+status+"')";
                ps.executeUpdate(sqlSaveDetails);
            }

        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}
