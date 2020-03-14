package FunctionLayer;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class OrderTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Order.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    Cupcake cup1= new Cupcake("Chocolade", "Crispy");
    Cupcake cup2= new Cupcake("Chocolade", "Bluechees");
    Cupcake cup3= new Cupcake("Chocolade", "Crispy");
    Cupcake cup4= new Cupcake("Almond", "Lemon");
    Cupcake cup5= new Cupcake("Almond", "Crispy");
    HashMap<Cupcake, Integer> products = new HashMap<>();


    @Test
    public void addCupcake() {

    }

    @Test
    public void getSum() {
    }
}
