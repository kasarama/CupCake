package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AllCustomers extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Customer[] allCustomers= CustomerMapper.listOfCustomersWithOrders();
        request.setAttribute("allCustomers", allCustomers);

        return "allCustomers";
    }

    /*
    if (request.getSession().getAttribute("email") != null) {
            Customer[] allCustomers = CustomerMapper.listOfCustomersWithOrders();
            request.setAttribute("allCustomers", allCustomers);
            return "allCustomers";
        } else return "index";
    }
     */
}
