package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Magdalena
public class ShowOrders extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        /*
        todo read orders of given customer from database and pack them in one object to be reade on orderspage.jsp
        todo #2
         */

        String email="tmp@mail"; //todo !get email of logged ind customer!
        int saldo= CustomerMapper.saldo(email);

        Order[] emptyOrders = OrderMapper.ListOfOrders(email);
        Order[] orders = OrderMapper.ListOfOrdersWithCupcakes(email);

        request.setAttribute("saldo", saldo);
        request.setAttribute("orders", orders);




        return "orderspage";
    }
}
