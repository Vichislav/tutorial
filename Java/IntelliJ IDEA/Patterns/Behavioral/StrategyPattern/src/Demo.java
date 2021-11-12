//package refactoring_guru.strategy.example;

import strategy.Order;
import strategy.PayByCreditCard;
import strategy.PayByPayPal;
import strategy.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * World first console e-commerce application.
 */
public class Demo {
    // Создаем объект типа HashMap<>() и запихиваем в переменную типа Map<Integer, Integer> с именем  priceOnProducts
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    // Создаем объект типа InputStreamReader(System.in) передаем его в создаваемый объект BufferedReader и записываем в перменную типа BufferedReader
    // Эта херь нужна для считывания клавиш наверное
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // Создаем объект типа ордер (new Order()) и запихваем в переменную order типа Order (private static Order order )
    private static Order order = new Order();
    // Объявляем переменную strategy типа PayStrategy
    private static PayStrategy strategy;

    // Заполняем двумерный массив цен priceOnProducts (стр 19)
    static {
        // put метод класса Map()
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    // Суть шаблона стратегия - вынос части кода
    // в собственные классы, реализующие один интерфейс (абстрактный класс).
    // Это позволяет увеличить уровень абстракции изначального класса,
    // а так же дает возможность смены алгоритмов на ходу.

    public static void main(String[] args) throws IOException
    {
        // While(true) {} - бесконечный цикл
        // Пока не закрыт заказ (order) делаем тело цикла
        // ! - приставка не, логическое отрицание
        // order.isClosed() - заказ.Закрыт() возвращает false если он не закрыт
        // соответственно в начале когда он не закрыт возвращает собственно false и приставкой не (!) инвертирует его в true
        while (!order.isClosed())
        {
            int cost;
            String continueChoice;

            // делаем тело цикла do пока проверка (стр. 63) есть true
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");

                // Сначала вызывается reader.readLine() метод, который ждет ввода строки и нажатия Enter
                // После введения строки, эта строка запихивается в метод Integer.parseInt()
                // На выходе получаем инт записываемый в перменную типа int имени choice
                int choice = Integer.parseInt(reader.readLine());
                // get (метод Map) позволяет нам получить значение из массива priceOnProducts по ключу, в роли ключа мы передаем choice
                cost = priceOnProducts.get(choice);
                // выводим
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
                // в то время как (переменная continueChoice эквивалентна/ровна "Y", если да то возвращемся к do, если нет то идем дальше)
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                // в зависимости от выбора клиента выбираем какой объект (PayByPayPal или PayByCreditCard) будет реализовывать наш интерфейс strategy
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }

            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            // вызываем метод processOrder в который передаем ссылку strategy которая ведет нас на один из методов (collectPaymentDetails в PayByPayPal или PayByCreditCard)
            order.processOrder(strategy);
            //
            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            //если мы готовы заплатить (ввели P/p) то идем дальше
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                //сначала в условие метода getTotalCost возвращает в метод pay (реализованный в PayByPayPal или PayByCreditCard) значение конечной цены
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}
