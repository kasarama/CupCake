package FunctionLayer;

public class HelpClass {
    public static int price (String bottom, String topping) {
        int bPrice=0;
        int tPrice=0;

        switch (bottom){
            case "Chocolate" :
            case "Vanilla":
            case "Nutmeg":
            case "Blueberry":
            case "Rasberry":
                bPrice=5;
            case "Pistacio":
            case "Crispy":
            case "Strawberry":
                bPrice=6;
            case "Almond":
            case "RumRaisin":
                bPrice=7;
            case "Orange":
            case "Lemon":
                bPrice=8;
            case"BlueCheese":
                bPrice=9;
        default:
            System.out.println("Wrong componentName");}
        return bPrice+tPrice;

    }
}
