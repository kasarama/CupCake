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

    public static User createUser( String email, String password, String fName, String sName ) throws LoginSampleException {
        User user = new User(email, password, fName, sName);
        UserMapper.createUser( user );
        return user;
    }

}
