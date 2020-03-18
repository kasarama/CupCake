package Util;

import DBAccess.CustomerMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import java.util.ArrayList;

public class HelpClass {
    public static void saldoController(String email, Order order) {
        /*todo saldo should be visible after customer logs in.
           If saldo is lower than 50 kr , customer gets msg about that after loging in
           or after saldo gets lower than 50 kr so on pay page (that could be an alert).
           If customer does not have enough money to purchase all the cupcakes from the cart
           he/she gets msg abut that and choice of editing the order or saving it

          todo
          customer must have enogh money an account to order all the items from cart.

         */
    }
    public static ArrayList<String[]> orderTable(Order order) throws LoginSampleException {
        ArrayList<String[]> table = new ArrayList<>();
        for (Cupcake c: order.getProducts().keySet()) {
            String[] line = new String[4];
            line[0] = c.getBottom();
            line[1] = c.getTopping();
            line[2] = String.valueOf(c.getPrice());
            line[3] = String.valueOf(order.getProducts().get(c));
            table.add(line);
        }

        return table;
    }


}
