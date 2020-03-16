package PresentationLayer;

import DBAccess.OrderMapper;
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
        String session = request.getSession().getId();
        Cupcake cupcake = new Cupcake(bottom, topping);
     OrderLines.getOrder().addCupcake(new Cupcake(bottom, topping),quantity);
        int items= OrderLines.getOrder().items();
        request.setAttribute("cart", items);
        return "index";
    }

}
