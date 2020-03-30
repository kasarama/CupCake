package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Magdalena
public class ShowOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        /*
        todo read orders of given customer from database and pack them in one object to be reade on orderspage.jsp
        */

        String email=request.getSession().getAttribute("email").toString();
        int saldo= CustomerMapper.saldo(email);

        Order[] orders = OrderMapper.ListOfOrdersWithCupcakes(email);

        int items=0;
        Order order = (Order) request.getSession().getAttribute("orderCart");
        if (order!=null) {
            items = order.items();
        }
        request.setAttribute("cart", items);
        request.setAttribute("saldo", saldo);
        request.setAttribute("ordersArray", orders);




        return "orderspage";
    }
}
