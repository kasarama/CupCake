package PresentationLayer;

import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
//Magdalena
public class ShowCart extends Command {
    //todo save each cupcake and its quantity in an array, add each array to the list and set as an attribute on request
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        Order order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = new ArrayList<>();

        for (Cupcake c: order.getProducts().keySet()) {
            String[] line = new String[4];
            line[0] = c.getBottom();
            line[1] = c.getTopping();
            line[2] = String.valueOf(c.getPrice());
            line[3] = String.valueOf(order.getProducts().get(c));
            cartLines.add(line);
        }
        request.setAttribute("items", cartLines);

        return "cartpage";
    }
}
/*

<%
	out.println("Loop will run 5 times.<br>");
        int i = 1;
	// while loop that runs five times
        while (i<6) {
            out.println("we are in loop value is : "+i+"<br>");
	    i++;
        }
        out.println("Now we are out of while loop.");
    %>

 */
