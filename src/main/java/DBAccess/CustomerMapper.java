package DBAccess;

import FunctionLayer.Cupcake;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;

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
            String sql = "select * from users where email='"+email+"'";
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

    public static boolean updateSaldo(String email, int sum) throws LoginSampleException {
        boolean updated=false;
        int affectedRows=0;
        try{
            Connection con = Connector.connection();
            String sql = "UPDATE users SET saldo = saldo+"+sum+" WHERE email='"+email+"'";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);
            affectedRows=ps.getUpdateCount();


        } catch(SQLException |
                ClassNotFoundException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
            if (affectedRows!=0){
                updated=true;
                return updated;
            }
            return updated;
    }


    public static int numberOfCustomers () throws LoginSampleException {
        int number=0;
        try{
            Connection con = Connector.connection();
            String sql="SELECT Count(email) AS numberOfCustomers FROM users where not email='admin'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                number=resultSet.getInt("numberOfCustomers");


            }
        } catch(SQLException |
                ClassNotFoundException ex )

        {
            throw new LoginSampleException(ex.getMessage());
        }
        return number;
    }



    public static Customer[] listOfCustomersWithOrders() throws LoginSampleException {
        //todo make a list of customers that have some orders in DB(cupcake.order)
        //todo get all ordered cupcakes from DB and put them to appropriate orders
        //todo put orders to appropriate customers

        Customer[] listOfCustomers=new Customer[numberOfCustomers()];


        try{
            Connection con = Connector.connection();
            String customersSQL = "select users.email, firstname, lastname, saldo from users where not email='admin' group by email";
            String ordersSQL = "select orderID, email, sum from orders where comment='Paid'";
            String cupcakesSQL = "select * from orderdetails";
            int index=0;

            PreparedStatement ps = con.prepareStatement(customersSQL);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String email = resultSet.getString("email");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int saldo = resultSet.getInt("saldo");
                Customer customer = new Customer(email);
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setSaldo(saldo);
                listOfCustomers[index]=customer;
                index++;
            }


            ps = con.prepareStatement(ordersSQL);
            resultSet = ps.executeQuery();
            while (resultSet.next()){
                int orderID = resultSet.getInt("orderID");
                String email = resultSet.getString("email");
                int sum = resultSet.getInt("sum");
                Order order= new Order();
                order.setId(orderID);
                order.setSum(sum);

                for (int i = 0; i < listOfCustomers.length ; i++) {


                    if(listOfCustomers[i].getEmail().equals(email)){
                        listOfCustomers[i].add(order);
                    }

                }
            }

            ps = con.prepareStatement(cupcakesSQL);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                int orderID=resultSet.getInt("orderID");
                String bottom = resultSet.getString("bottom");
                String topping = resultSet.getString("topping");
                int quantity = resultSet.getInt("quantity");
                Cupcake cupcake = new Cupcake(bottom, topping);
                for (Customer customer: listOfCustomers) {
                    for (Order order: customer.getOrders()) {
                        if(order.getId()==orderID){
                            order.addCupcake(cupcake, quantity);
                        }
                    }
                }
            }

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }

        return listOfCustomers;
    }



}


