package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class OrderMapper {


    public static void newOrder (String email, Order order, String status) throws LoginSampleException {
        //todo Save Order in cupcake.order, read inserted OrderID, save orderdetails (Cupcakes) of that order

        int orderID=0;
        try{
            Connection con = Connector.connection();
            String sqlSaveOrder = "Insert into orders (email, sum, comment) values ('"+email+ "', "+order.getSum()+", 'Paid')";

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
                String sqlSaveDetails =  "Insert into orderdetails (orderID, bottom, topping, quantity) values (" +
                        orderID+", '"+bottom+"', '"+topping+"', "+quantity+")";
                ps.executeUpdate(sqlSaveDetails);
            }

        } catch(SQLException ex )
        {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }
    }


//returns number of orders of given customer that are saved in DB
    public static int numberOfOrders (String email) throws LoginSampleException {
        int number=0;
        try{
            Connection con = Connector.connection();
            String sql="SELECT Count(orders.orderID) AS numberOfOrders \n" +
                    "FROM orders where comment='Paid' and email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                number=resultSet.getInt("numberOfOrders");

            }
        } catch(SQLException ex )

        {
            ex.printStackTrace();
            throw new LoginSampleException(ex.getMessage());
        }

        return number;
    }
    public static Order[] ListOfOrders(String email) throws LoginSampleException {
        Order[] orderList = new Order[numberOfOrders(email)];

        try {
            Connection con = Connector.connection();
            String sqlOrderID = "select orderID, sum from orders where email='" + email + "' and  comment='Paid'";
            PreparedStatement ps = con.prepareStatement(sqlOrderID);
            ps = con.prepareStatement(sqlOrderID);
            ResultSet resultSet = ps.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                int orderID = resultSet.getInt("orderID");
                int sum = resultSet.getInt("sum");
                Order order = new Order();
                order.setId(orderID);
                order.setSum(sum);
                orderList[count] = order;
                count++;
            }


        } catch (SQLException | NullPointerException ex) {

            ex.printStackTrace();

            throw new LoginSampleException(ex.getMessage());
        }

        for (int i = 0; i <orderList.length ; i++) {
            int orderID= orderList[i].getId();

        }
        return orderList;
    }


    public static Order[] ListOfOrdersWithCupcakes(String email) throws LoginSampleException {

        Order[] orderList = ListOfOrders(email);

        String sql = "select bottom, topping, quantity from orderdetails where orderID=";


        try {
            Connection con = Connector.connection();

            for (int i = 0; i < orderList.length; i++) {
                int orderID= orderList[i].getId();
                sql = "select bottom, topping, quantity from orderdetails where orderID="+orderID;


                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();
int count =1;
                while (resultSet.next()) {
                    count++;
                    String bottom = resultSet.getString("bottom");
                    String topping = resultSet.getString("topping");
                    int quantity = resultSet.getInt("quantity");
                    Cupcake cupcake = new Cupcake(bottom, topping);
                    cupcake.setPrice(cupcake.price());
                    orderList[i].addCupcake(cupcake, quantity);
                    orderList[i].setSum(orderList[i].sum());

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

            throw new LoginSampleException(ex.getMessage());
        }return orderList;
    }

    public static void sendOrderToArch(String comment, int orderID) throws LoginSampleException {

            try {
                Connection con = Connector.connection();
                String sql = "update orders set comment='"+comment+"' where orderID="+orderID;
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();

                throw new LoginSampleException(ex.getMessage());
            }


    }



}