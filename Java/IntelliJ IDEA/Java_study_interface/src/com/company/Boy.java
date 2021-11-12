package com.company;

public class Boy implements Player, Study { //мы можем ипмлементтировать любое количество интерфейсов через запятую

    @Override
    public void Play() {
        System.out.println("Запускать через exe файл");
    }

    @Override
    public void read() {
        System.out.println("Люблю читать научную фантастику");
    }
}
