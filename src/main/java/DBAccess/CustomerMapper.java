package DBAccess;

import FunctionLayer.LoginSampleException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {

    public static int saldo(String email) throws LoginSampleException {
        int saldo = 0;
        try{
            Connection con = Connector.connection();
            String sql = "select * from customers where email='"+email+"'";
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

    public static void updateSaldo(String email, int sum) throws LoginSampleException {
        try{
            Connection con = Connector.connection();
            String sql = "UPDATE customers SET saldo = saldo-"+sum+" WHERE email='"+email+"'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate(sql);

        } catch(SQLException |
                ClassNotFoundException ex )
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

}


