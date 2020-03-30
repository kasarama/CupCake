package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Magdalena
public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String destination = request.getParameter("destination");

        int items=0;
        Order order = (Order) request.getSession().getAttribute("orderCart");
        if (order!=null) {
            items = order.items();
        }
        request.setAttribute("cart", items);
        return destination;
    }
}
