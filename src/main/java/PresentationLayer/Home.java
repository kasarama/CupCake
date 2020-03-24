package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Home extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Order order = OrderLines.getOrder();
        int items= order.items();
        request.setAttribute("cart", items);

        return "index";
    }
}
