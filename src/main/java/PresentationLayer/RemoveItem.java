package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class RemoveItem extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        Order order = OrderLines.getOrder();
        Cupcake cupcake = new Cupcake(bottom, topping);
        int cupcakeTotalPrice = order.getProducts().get(cupcake)*cupcake.price();

        order.getProducts().remove(cupcake);
        order.setSum(order.getSum()-cupcakeTotalPrice);
        order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(order);
        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());

        if(request.getSession().getAttribute("email") != null){

            String email=request.getSession().getAttribute("email").toString();
            int saldo= CustomerMapper.saldo(email);
            request.setAttribute("saldo", saldo);
        } else
            request.setAttribute("saldo", null);


        return "cartpage";
    }
}
