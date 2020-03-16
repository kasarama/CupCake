package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//Magdalena
public class NewOrderLine extends Command {
    /*
    Reads bottom topping and quantity from index.jsp, creates new Cupcake ,
     sets price for Cupcake, adds Cupcake to Order, sets price on Order
    calls a method to count number of items in cart(no of Cupcakes)
    */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String bottom = request.getParameter( "bottom" );
        String topping = request.getParameter( "topping" );
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        Cupcake cupcake = new Cupcake(bottom, topping);
        cupcake.setPrice(cupcake.price());

        Order order= OrderLines.getOrder();
        order.addCupcake(cupcake,quantity);
        order.setSum(order.sum());

        int items= OrderLines.getOrder().items();
        request.setAttribute("cart", items);
        return "index";
    }

}