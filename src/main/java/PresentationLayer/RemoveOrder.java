package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import FunctionLayer.Customer;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RemoveOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String comment= request.getParameter("comment");
        int orderID= Integer.parseInt(request.getParameter("orderID"));
        OrderMapper.sendOrderToArch(comment,orderID);

        Customer[] listOfOrdersOfCustomer=CustomerMapper.listOfCustomersWithOrders();
        request.setAttribute("listOfOrdersOfCustomer", listOfOrdersOfCustomer );


        return "ordersAdminpage";
    }
}
