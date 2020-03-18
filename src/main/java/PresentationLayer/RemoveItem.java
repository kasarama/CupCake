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
        String email="tmp@mail"; // todo change to email of loged in customer
        String bottom = request.getParameter("bottom");
        String topping = request.getParameter("topping");
        Order order = OrderLines.getOrder();
        Cupcake cupcake = new Cupcake(bottom, topping);
        int cupcakeTotalPrice = order.getProducts().get(cupcake)*cupcake.price();

        order.getProducts().remove(cupcake);
        order.setSum(order.getSum()-cupcakeTotalPrice);
        int saldo= CustomerMapper.saldo(email);
        order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(email, order);
        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);

        return "cartpage";
    }
}
