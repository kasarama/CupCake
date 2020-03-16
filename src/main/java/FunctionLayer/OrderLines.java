package FunctionLayer;

public class OrderLines {
    //todo initialize Order from index.jsp that is static . Is used to save Cupcakes added to cart
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
