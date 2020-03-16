package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Magdalena
public class DeleteOrderLine extends Command {
    //todo delete cupcake from order
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
      //String[] item = request.getParameter()
        return "cartpage";
    }
}
