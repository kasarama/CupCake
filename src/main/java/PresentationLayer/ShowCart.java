package PresentationLayer;

import DBAccess.CustomerMapper;
import FunctionLayer.*;
import Util.HelpClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

//Magdalena
public class ShowCart extends Command {
    //todo save each cupcake and its quantity in an array, add each array to the list and set as an attribute on request
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int saldo = 0;
        if(request.getSession().getAttribute("email") != null){

        String email=request.getSession().getAttribute("email").toString();
        saldo= CustomerMapper.saldo(email);
        request.setAttribute("saldo", saldo);
        } else
            request.setAttribute("saldo", null);

        Order order = OrderLines.getOrder();
        ArrayList<String[]> cartLines = HelpClass.orderTable(order);


        int items= order.items();
        request.setAttribute("cart", items);
        request.setAttribute("items", cartLines);
        request.setAttribute("sum", order.getSum());

        int difference=saldo-order.getSum();
        String payStatus ="";

        if (difference<0){
            payStatus ="Du har dæsvære ikke nok penge på din konto. " +
                    "Kontakt butikken for at indbetale på din konto, slet nogle af Cupcakes fra din indkøbskurv eller slet ordre ";

        }else{
            payStatus =  "Bekræft din bestiling ved at klikke \"Betal\" knappen";

        }
        request.setAttribute("payStatus", payStatus);



        return "cartpage";
    }
}
