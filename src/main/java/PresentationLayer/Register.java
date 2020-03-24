package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class Register extends Command {
    //todo require email format

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");

        String page="registerpage";
        String registerMSG="";

        if(email.equals("") || password1.equals("") || password1.equals("") || fName.equals("") || lName.equals("")){

            registerMSG="Nogle af de verdi du har indtastet kunne ikke valideres, prøv venligst igen";
        } else

        if ( password1.equals( password2 ) ) {

               try {
                   User user = LogicFacade.createUser(email, password1, fName, lName);
                   HttpSession session = request.getSession();

                   session.setAttribute("email", email);
                   session.setAttribute("user", user);
                   session.setAttribute("fName", user.getfName());
                   session.setAttribute("sName", user.getsName());
                   page = "customerpage";
               }catch (SQLException ex){
                   registerMSG="Email findes allerede i vores database. Prøv igen eller log ind";

               }





        } else
            if (!password1.equals(password2)){
            registerMSG="De to adgangskoder var ikke ens, prøv igen";
            request.setAttribute("givenemail", email);
            request.setAttribute("givenfName", fName);
            request.setAttribute("givenelName", lName);

        } else {
                registerMSG="System fejl nr 666. Kontak vnligst butikken: (tlf) 81819292";
            }
        request.setAttribute("registerMSG", registerMSG);
        Order order = OrderLines.getOrder();
        int items= order.items();
        request.setAttribute("cart", items);
        return page;
    }

}
