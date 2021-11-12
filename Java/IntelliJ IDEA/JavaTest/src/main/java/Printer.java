public class Printer {

    private int price;
    private String name;

    Printer (int price, String name) {
        this.price = price;
        this.name = name;
    }
    void getPrice () {
        System.out.println(price);
    }
    void getName () {
        System.out.println(name);
    }
}
