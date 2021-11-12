package com.company;

public class Cow extends Animal {

    public Cow(String say, int teeth) { /* 1. создаем конструктор для ввода переменных */
        setTeeth(teeth);
        setSay(say);

    }

    public String getSay() {    /* 2. переопределение метода getSay */
        String say = super.getSay(); /*3. забираем данные из изначального метода*/
        return say + " New !"; /*4. Добавляем свое*/
    }

    void mu () {
        System.out.println(getSay() + " во все " + getTeeth() + " зуба");
    }

}
