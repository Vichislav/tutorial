package com.company;

public class Girl implements Player, Study{

    @Override
    public void Play() {
        System.out.println("Запускать с ярлыка на рабочем столе");
    }

    @Override
    public void read() {
        System.out.println("Люблю читать романы");
    }
}
