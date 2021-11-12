public class Scan {
    private int price; /*создали приватные (переменные) для класса */
    private String name;

    Scan (int price, String name) {  /*создали конструктор  для того что бы создавая экземпляр мы сразу же вводили */
        this.price = price;          /*значение переменных как аргументы экземпляра класса*/
        this.name = name;
    }
    void getPrice () {                 /*создали методы для класса, доступные при создании экземпляра */
        System.out.println(price);
    }
    void getName () {
        System.out.println(name);
    }
}

