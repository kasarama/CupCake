package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

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
                String sqlSaveDetails =  "Insert into orderdetails (orderID, bottom, topping, quantity) values (" +
                        orderID+", '"+bottom+"', '"+topping+"', "+quantity+")";
                ps.executeUpdate(sqlSaveDetails);
            }

        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
    }


//returns number of orders of given customer that are saved in DB
    public static int numberOfOrders (String email) throws LoginSampleException {
        int number=0;
        try{
            Connection con = Connector.connection();
            String sql="SELECT Count(orders.orderID) AS numberOfOrders \n" +
                    "FROM orders where email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                number=resultSet.getInt("numberOfOrders");

            }
        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
        return number;
    }


    public static Order[] listaZamowien(String email) throws LoginSampleException {
        Order[]orderList= new Order[numberOfOrders(email)];
        try{
            Connection con = Connector.connection();
            String sql="SELECT orders.orderID, orderdetails.bottom, orderdetails.topping, orderdetails.quantity\n" +
                    "FROM orders\n" +
                    "INNER JOIN orderdetails ON orders.orderID=orderdetails.orderID where email='"+email+"' order by orderID;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int orderID = resultSet.getInt("orderID");
                String bottom = resultSet.getString("bottom");
                String topping = resultSet.getString("topping");
                int quantity = resultSet.getInt("quantity");
                Order order = new Order();
                Cupcake cupcake= new Cupcake(bottom, topping);
                cupcake.setPrice(cupcake.price());

                if(orderList[0]==null){
                    orderList[0]=order;
                    orderList[0].setSum(orderList[0].sum());
                    orderList[0].setId(orderID);
                    System.out.println("dodano pierwsze zamowienie o ID "+ orderList[0].getId());
                } else for (int i = 0; i < orderList.length; i++) {
                    if (orderList[i]!=null && orderList[i].getId()==orderID){
                        orderList[i].addCupcake(cupcake, quantity);
                        orderList[i].setSum(orderList[i].sum());
                        System.out.println("dodano cupcake do zamowienia znajdujacego sie na tablicy o ID: " +orderList[i].getId()+". Suma zamowienia wynosi: "+ orderList[i].getSum());
                    } else for ( i = 0; i < orderList.length; i++)
                        if (orderList[i] == null) {

                            orderList[i] = order;
                            orderList[i].setId(orderID);
                            orderList[i].setSum(orderList[i].sum());

                        }

                }
            }
            for (int i=0; i<orderList.length; i++){
                System.out.println(orderList[i].getId());
            }
        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderList;
    }


    public static Order[] ListOfOrders(String email) throws LoginSampleException {
        Order[]orderList= new Order[numberOfOrders(email)];
        try{
            Connection con = Connector.connection();
            String sqlOrderID="select orderID, sum from orders where email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sqlOrderID);
            ps = con.prepareStatement(sqlOrderID);
            ResultSet resultSet = ps.executeQuery();
            int count=0;
            while (resultSet.next()){
                int orderID=resultSet.getInt("orderID");
                int sum = resultSet.getInt("sum");
                Order order =new Order();
                order.setId(orderID);
                order.setSum(sum);
                orderList[count]=order;
                count++;
            }


        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }

        return orderList;
    }


    public static Order[] ListOfOrdersWithCupcakes(String email) throws LoginSampleException {
        Order[] orderList = ListOfOrders(email);

        for (int i = 0; i < orderList.length; i++) {
            try {
                Connection con = Connector.connection();
                String sql = "select bottom, topping, quantity from orderdetails where orderID=" + orderList[i].getId();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    String bottom = resultSet.getString("bottom");
                    String topping = resultSet.getString("topping");
                    int quantity = resultSet.getInt("quantity");
                    Cupcake cupcake = new Cupcake(bottom, topping);
                    orderList[i].addCupcake(cupcake, quantity);
                }
            } catch (SQLException |
                    ClassNotFoundException ex) {
                throw new LoginSampleException(ex.getMessage());
            }
        }return orderList;
    }



}