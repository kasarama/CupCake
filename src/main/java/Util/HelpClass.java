package Util;

import DBAccess.CustomerMapper;
import FunctionLayer.Cupcake;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderLines;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class HelpClass {

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
