package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowCart extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        System.out.println("showCart method called");
        return "cartpage";
    }
}
