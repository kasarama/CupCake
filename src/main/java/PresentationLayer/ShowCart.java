package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.*;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//Magdalena
public class ShowCart extends Command {
    //todo save each cupcake and its quantity in an array, add each array to the list and set as an attribute on request
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        String email="tmp@mail"; //todo !get email of logged ind customer!
        int saldo= CustomerMapper.saldo(email);
        Order order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(order);

        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);

        return "cartpage";
    }
}
