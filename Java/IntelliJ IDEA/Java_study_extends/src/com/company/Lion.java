package com.company;

public class Lion extends Animal {

    public Lion (String say, int teeth) { /* 1. создаем конструктор для ввода переменных */
        setTeeth(teeth);
        setSay(say);

    }

    public String getSay() {    /* 2. переопределение метода getSay */
        String say = super.getSay(); /*3. забираем данные из изначального метода*/
        return say + " RRRR "; /*4. Добавляем свое*/
    }

    void Rr () {
        System.out.println(getSay() + " во все " + getTeeth() + " зубов");
    }
}
