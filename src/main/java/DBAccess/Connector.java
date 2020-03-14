package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector
{
    //setting the URL to the IP@ and port # of the database to be used
    //"useradmin?": "use the "useradmin" database from this IP@ and port# (connection)
    private static final String URL = "jdbc:mysql://64.225.76.1:3306/useradmin?";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "CakeBoss#Of#Cups_2020";

    /* Mag's DB Connection
    private static final String URL = "jdbc:mysql://localhost:3306/cupcake?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1909145380Hanna";
     */

    private static Connection singleton;

    public static void setConnection( Connection con ) {
        singleton = con;
    }

    public static Connection connection() throws ClassNotFoundException, SQLException {
        if ( singleton == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return singleton;
    }

}
