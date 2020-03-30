package DBAccess;

import FunctionLayer.LoginSampleException;
import Util.HelpClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws LoginSampleException {
        try {
            if (singleton == null || singleton.isClosed()) {
                setDBCredentials();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new LoginSampleException("Huston, we've got a problem! \nRing til Huston(+45 81917452) og sig \"Fejlkode DBConnection\"!");
        }
        return singleton;
    }


    public static void setDBCredentials() {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            URL = System.getenv("JDBC_CONNECTION_STRING");
            USERNAME = System.getenv("JDBC_USER");
            PASSWORD = System.getenv("JDBC_PASSWORD");
        } else {

            URL = "jdbc:mysql://localhost:3306/cupcake?serverTimezone=UTC";
            USERNAME = "root";
            PASSWORD = "1909145380Hanna";
        }

    }
}
