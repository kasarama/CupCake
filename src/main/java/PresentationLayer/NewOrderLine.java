package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Magdalena
public class NewOrderLine extends Command {
    //todo read bottom, topping and quantity from index, create a new Cupcake, add to order ,
    // count sum of order, count number of Cupcakes in cart
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String bottom = request.getParameter( "bottom" );
        String topping = request.getParameter( "topping" );
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Order order = OrderLines.getOrder();
        Cupcake cupcake = new Cupcake(bottom, topping);
        cupcake.setPrice(cupcake.price());
        order.addCupcake(cupcake,quantity);
        order.setSum(order.sum());

        int items= order.items();
        request.setAttribute("cart", items);
        return "index";
    }

}