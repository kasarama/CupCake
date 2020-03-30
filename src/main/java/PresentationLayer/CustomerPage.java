package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CustomerPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, SQLException {
        String email=request.getSession().getAttribute("email").toString();
        try {
            request.setAttribute("saldo", CustomerMapper.saldo(email));
        } catch (LoginSampleException e) {
            request.setAttribute("saldo", 0);
        }

        int items=0;
        Order order = (Order) request.getSession().getAttribute("orderCart");
        if (order!=null) {
            items = order.items();
        }
        request.setAttribute("cart", items);
        return "customerpage";
    }
}
