package PresentationLayer;

import DBAccess.CustomerMapper;
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
        String page="loginpage";
        String error="ErrorMSG";
        Customer customer=null;
        try {
            customer = LogicFacade.login(email, password);

            if (request.getParameter("origin") != null) {
                page = request.getParameter("origin");
            }





        }catch (LoginSampleException ex){
            error = ex.getMessage();
            ex.printStackTrace();
            page="loginpage";
            request.setAttribute("errorMSG", error);
        }
        if (customer!=null) {
            HttpSession session = request.getSession();
            session.setAttribute("email", customer.getEmail());
            session.setAttribute("firstName", customer.getFirstName());
            if (email.equals("admin@olsker.cupcakes")) {
                page = "adminpage";
            } else {
                try {
                    request.setAttribute("saldo", CustomerMapper.saldo(email));
                } catch (LoginSampleException e) {
                    request.setAttribute("saldo", null);
                }
                page = "customerpage";
            }
        }

        Order order = OrderLines.getOrder();
        int items= order.items();
        request.setAttribute("cart", items);


        return page;
    }

}
