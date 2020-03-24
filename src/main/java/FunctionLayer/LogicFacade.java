package FunctionLayer;

import DBAccess.CustomerMapper;


import java.sql.SQLException;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {


    public static Customer login( String email, String password ) throws LoginSampleException {

Customer customer =new Customer(email);
       try {
           customer= CustomerMapper.login(email, password);
           return customer;
       }catch (LoginSampleException ex){
             customer.setEmail("error");

           return customer;

       }

    }

    public static Customer createCustomer( String email, String password, String fName, String sName ) throws LoginSampleException, SQLException {
        Customer customer  = new Customer(email);
        customer.setSaldo(0);
        customer.setFirstName(fName);
        customer.setLastName(sName);
        customer.setPassword(password);


        CustomerMapper.createCustomer( customer, password );
        return customer;
    }

}
