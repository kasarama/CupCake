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
public class ConfirmOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
    // todo !CHANGE EMAIL TO EMAIL OF LOGGED IN CUSTOMER!
        //  todo show saldo of logged in customer, show order lines,
        //   show saldo after paying, show msg about saldo if low/to low
        String email="tmp@mail";
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
        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);


        return "confirmpage";
    }
}
