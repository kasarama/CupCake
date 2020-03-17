package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

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
        ArrayList<String[]> cartLines = new ArrayList<>();

        for (Cupcake c: order.getProducts().keySet()) {
            String[] line = new String[4];
            line[0] = c.getBottom();
            line[1] = c.getTopping();
            line[2] = String.valueOf(c.getPrice());
            line[3] = String.valueOf(order.getProducts().get(c));
            cartLines.add(line);
        }

        String saldoMSG ="";
        if((saldo-order.getSum())<0){
             saldoMSG = "Du har ikke nok penge på din konto. Kontak butikken for TOP-UP";

            }
        

        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);
        request.setAttribute("saldoToLow", saldoMSG );



        return "cartpage";
    }
}
