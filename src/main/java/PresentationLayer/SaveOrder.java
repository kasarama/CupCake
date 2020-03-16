package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        //todo (when we know which e-mail is logged in, we will change "tmp@mail" to that e-mail)
        //Saves order in DB

        Order order = OrderLines.getOrder();
                OrderMapper.newOrder("tmp@mail", order, "inCart");
                order.removeAll();
        request.setAttribute("msg", "Din ordre er nu gemt i din kurv og du kan fortsætte med den når du vil");
        return "index";
    }
}
