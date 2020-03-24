package FunctionLayer;

import org.junit.Test;

import static org.junit.Assert.*;

public class CupcakeTest {
    Cupcake cupcake = new Cupcake("Chocolate", "Crispy");

    @Test
    public void getPrice() {
        int result = cupcake.price();
        assertEquals(11, result, 0.0000001);
    }

}