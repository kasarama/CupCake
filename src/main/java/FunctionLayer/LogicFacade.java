package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {


    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String email, String password ) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser( user );
        return user;
    }
    public static void addToOrder (String bottom, String topping, int quantity, String sessionID) throws LoginSampleException {
        OrderMapper.addToOrder(bottom, topping, quantity, sessionID);
    }
    public static void saveOrde(){
        //todo
    }

    public static void showCart (){
        //todo prints all order lines on cartpage with sum of order and "slet" button at each line


    }



}
