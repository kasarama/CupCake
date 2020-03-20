package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String fName = request.getParameter("fName");
        String sName = request.getParameter("sName");
        if ( password1.equals( password2 ) ) {
                User user = LogicFacade.createUser( email, password1, fName, sName );
                HttpSession session = request.getSession();

            session.setAttribute("email",email);
            session.setAttribute( "user", user );
            session.setAttribute( "fName", user.getfName() );
            session.setAttribute( "sName", user.getsName() );
            Order order = OrderLines.getOrder();
            int items= order.items();
            request.setAttribute("cart", items);

            return "index";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
