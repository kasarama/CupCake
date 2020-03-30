package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * @author Magdalena Wawrzak
 */
public class AllCustomers extends Command {

    /**
     * Checks if email from session's attribute is admins e-mail.
     * If is, calls CustomerMapper to fill up the array with all customers from database
     * sets array as request's attribute.
     * returns "index" if e-mail is not admin's or "allCustomers" if e-mail is admin's
     * @param request
     * @param response
     * @return page
     * @throws LoginSampleException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String page = "index";
        if (request.getSession().getAttribute("email").equals("admin@olsker.cupcakes")) {


            Customer[] allCustomers = CustomerMapper.listOfCustomersWithOrders();
            if (allCustomers == null) {
                request.setAttribute("allCustomers", "noCustomers");
                page = "allCustomers";
            } else {
                request.setAttribute("allCustomers", allCustomers);
            page = "allCustomers";
        }
        }
        return page;
    }

}
