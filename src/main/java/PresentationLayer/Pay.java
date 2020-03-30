package PresentationLayer;

import DBAccess.CustomerMapper;
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Magdalena
public class Pay extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //todo displays error if saldo to low or adds order to DB as paid, and updates saldo
        String email=request.getSession().getAttribute("email").toString();
        int saldo = CustomerMapper.saldo(email);

        Order order = (Order) request.getSession().getAttribute("orderCart");
        order.setSum(order.sum());
        OrderMapper.newOrder(email, order, "Paid");
        CustomerMapper.updateSaldo(email, (order.getSum()*(-1)));
        saldo = CustomerMapper.saldo(email);
        request.getSession().setAttribute("orderCart", null);


        request.setAttribute("cart", 0);

        request.setAttribute("saldo", saldo);


        return "paypage";
    }
}
