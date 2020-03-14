package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class NewOrderLine extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String bottom = request.getParameter( "bottom" );
        String topping = request.getParameter( "topping" );
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Order order =LogicFacade.addToOrder(bottom, topping, quantity);
        System.out.println("order" + order.toString());
        request.setAttribute("msg", "Order has been saved or maybe has not - idk");
        int itemsInCart = 0;
        for (Cupcake cupcake: order.getProducts().keySet() ){
            int tmp = itemsInCart;
            itemsInCart=order.getProducts().get(cupcake) +tmp;
        }
        System.out.println(itemsInCart +" items in cart");
        request.setAttribute("cart", itemsInCart);


        return "index";
    }

}
