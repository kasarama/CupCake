package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response )  {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        String error="";
        String page="index";
        String firstName="";

        try {


            Customer customer = LogicFacade.login(email, password);


            if (request.getParameter("origin") != null) {
                page = request.getParameter("origin");
            }

            if (customer.getEmail().equals("admin@olsker.cupcakes")) {
                page = "adminpage";
            }

            if (customer.getEmail().equals("error")) {
                error = "Jeg kan ikke genkende dig. Prøv venligst igen eller register dig som ny Kunde";
                page="loginpage";
            } else {

                HttpSession session = request.getSession();
                firstName=customer.getFirstName();
                session.setAttribute("customer", customer);
                session.setAttribute("email", email);  // ellers skal man skrive  customer.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
                session.setAttribute("firstName", firstName);  // ellers skal man skrive  customer.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

            }
        }catch (LoginSampleException ex){
            error="Systemfejl nr 666. Kontak butiken - tel: 81819292";
            ex.printStackTrace();
        }
        request.setAttribute("errorMSG", error);
        Order order = OrderLines.getOrder();
        int items= order.items();
        request.setAttribute("cart", items);

        return page;
    }

}
