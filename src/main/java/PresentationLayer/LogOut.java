package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        Order order = OrderLines.getOrder();
        order.clear();
        int items= order.items();
        request.setAttribute("cart", items);
        session.setAttribute( "user", null );
        session.setAttribute("email", null);
        return "index";
    }
}
