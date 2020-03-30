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
        String payStatus ="";
        if(request.getSession().getAttribute("email") != null){

        String email=request.getSession().getAttribute("email").toString();
        saldo= CustomerMapper.saldo(email);
        request.setAttribute("saldo", saldo);
        } else
            request.setAttribute("saldo", null);

        Order order = (Order) request.getSession().getAttribute("orderCart");
        int items=0;
        try {
            ArrayList<String[]> cartLines = HelpClass.orderTable(order);
            items= order.items();
            request.setAttribute("items", cartLines);
            request.setAttribute("sum", order.getSum());
            int difference=saldo-order.getSum();

            if (difference<0){
                payStatus ="Du har dæsvære ikke nok penge på din konto. " +
                        "Kontakt butikken for at indbetale på din konto, slet nogle af Cupcakes fra din indkøbskurv eller slet ordre ";

            }else{
                payStatus =  "Bekræft din bestiling ved at klikke på \"Betal\" knappen";

            }
            request.setAttribute("payStatus", payStatus);

        } catch (NullPointerException ex){

            System.out.println("So the order wasn't initialized");

        }
        request.setAttribute("cart", items);














        return "cartpage";
    }
}
