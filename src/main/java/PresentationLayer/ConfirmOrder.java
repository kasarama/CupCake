package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//Magdalena
public class ConfirmOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //  todo show saldo of logged in customer, show order lines,
        //   show saldo after paying, show msg about saldo if low/to low
        String email=request.getSession().getAttribute("email").toString();
        int saldo= CustomerMapper.saldo(email);
        Order order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(order);


        int items= order.items();
        request.setAttribute("cart", items);
        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);

        int difference=saldo-order.getSum();
        String page="";
        if (difference<0){
            page = "cartpage";
        }else{
            page = "confirmpage";
        }

        return page;



    }
}
