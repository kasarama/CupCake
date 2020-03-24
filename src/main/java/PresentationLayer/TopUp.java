package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

//Magdalena
public class TopUp extends Command {
    /*
    todo for given email and amount updates saldo of user with that email of that amount.
     Checks if updated has affected any rows and returnes msg about that
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        int amount = Integer.parseInt(request.getParameter("amount"));
        String msg="";
        boolean updated;
        if (!email.equals("")) {
                updated=CustomerMapper.updateSaldo(email, amount);
                int saldo = CustomerMapper.saldo(email);
                if (updated==true){
                msg = "Saldo er blevet opdateret for " + email + ". Ny saldo: " + saldo + " kr.";
                } else {
                    msg = "Det ser ud til at kunde med email: " + email + " kunne ikke findes i databasen. Prøv venligst igen";
                }

        } else{
            msg="Høv, det ser ud til at du har glemt at indtase e-mail!";}

        request.setAttribute("topUp", msg);

        return "topUppage";
    }
}
