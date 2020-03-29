package FunctionLayer;

public class OrderLines {
    private static Order order;
    public static void initOrder(){
        if (order==null){
            order=new Order();
        }
    }


    public static Order getOrder() {
        return order;
    }
}