package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;

//Magdalena
public class AllOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        /*
        todo Fill up an array with customers,
         todo how to handle customers with no orders??
       */
        Customer[] listOfOrdersOfCustomer=CustomerMapper.listOfCustomersWithOrders();
        for (Customer c: listOfOrdersOfCustomer) {
          /*  if (c.getOrders().size()==0){
                listOfOrdersOfCustomer.remove(c);
            }*/
        }

        request.setAttribute("listOfOrdersOfCustomer", listOfOrdersOfCustomer );
        return "ordersAdminpage";
    }
}
