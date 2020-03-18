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
    // todo !CHANGE EMAIL TO EMAIL OF LOGGED IN CUSTOMER!
        //  todo show saldo of logged in customer, show order lines,
        //   show saldo after paying, show msg about saldo if low/to low
        String email="tmp@mail";
        int saldo= CustomerMapper.saldo(email);
        Order order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(order);
        int difference=saldo-order.getSum();

        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());
        request.setAttribute("saldo", saldo);
        if (difference<0){
            request.setAttribute("payStatus","Du har dæsvære ikke nok penge på din konto. " +
                    "Slet nogle af Cupcakes fra din indkøbskurv, gem ordre for at bestile senere eller slet den ");
            return "cartpage";
        }else{
            request.setAttribute("payStatus",  "Tak for din bestiling! Klik for at se kvittering");
            return "confirmpage";
        }





    }
}
