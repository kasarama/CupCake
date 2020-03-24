package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException, SQLException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, firstName, lastName) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getfName() );
            ps.setString( 4, user.getsName() );

            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();

        } catch ( ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        } catch ( SQLException ex ){
            throw new SQLException();

        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT firstName, lastName FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String fName = rs.getString( "firstName" );
                String sName = rs.getString( "lastName" );
                User user = new User( email, password, fName, sName);

                return user;
            } else {

                User user = new User( "error", "error", "", "");

                return user;
              //  throw new LoginSampleException( "Bruger kunne ikke valideres" );
            }
        } catch (  SQLException ex ) {
            throw new LoginSampleException("Kan ikke forbindes til databasen");
        } catch ( ClassNotFoundException ex){
            throw new LoginSampleException("Class not found exc.");

        }
    }

}
