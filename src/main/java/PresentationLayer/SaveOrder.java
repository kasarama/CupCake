package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        Order order = OrderMapper.newOrder("b@b", request.getSession().getId());

        request.setAttribute("msg", "Din ordre er nu gemt i din kurv og du kan fortsætte med den når du vil");
        return "index";

    }
}
