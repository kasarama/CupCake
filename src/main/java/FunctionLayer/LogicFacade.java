package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {


    public static User login( String email, String password ) throws LoginSampleException {

User user=new User("","","","");
       try {
           user=UserMapper.login(email, password);
           return user;
       }catch (LoginSampleException ex){
             user.setEmail("error");

           return user;

       }

    }

    public static User createUser( String email, String password, String fName, String sName ) throws LoginSampleException, SQLException {
        User user = new User(email, password, fName, sName);
        UserMapper.createUser( user );
        return user;
    }

}
