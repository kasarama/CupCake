package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Magdalena Wawrzak
 */
public class NewOrderLine extends Command {
    //todo read bottom, topping and quantity from index.jsp, create a new Cupcake, add to order , count number of Cupcakes in cart

    /**
     * Creates Cupcake from request's parameters.
     * If session does not have an attribute "orderCart" instantiates Order at sets it on session.
     * Adds Cupcake to the sessions Order
     * Counts amount of Cupcakes in Order and sets it on request to be used on returned index.jsp page
     * @param request
     * @param response
     * @return "index"
     * @throws LoginSampleException
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String bottom = request.getParameter( "bottom" );
        String topping = request.getParameter( "topping" );
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();

        if(session.getAttribute("orderCart")==null) {
            OrderLines.initOrder();
            session.setAttribute("orderCart", new Order());

        }        


        Order order = (Order) session.getAttribute("orderCart");
        Cupcake cupcake = new Cupcake(bottom, topping);
        cupcake.setPrice(cupcake.price());
        order.addCupcake(cupcake,quantity);
        order.setSum(order.sum());

        int items= order.items();
        request.setAttribute("cart", items);
        return "index";

    }
}