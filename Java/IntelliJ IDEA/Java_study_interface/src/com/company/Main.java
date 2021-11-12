package com.company;

public class Main {

    public static void main(String[] args) {

        Boy ivan = new Boy();
        Girl alena = new Girl();

        Player unit1 = ivan;
        System.out.println("Если нужно запустить игру то я буду ");
        unit1.Play();
        System.out.println("----------------------------------");

        Player unit2 = alena;
        System.out.println("Если нужно запустить игру то я буду ");
        unit2.Play();
        System.out.println("----------------------------------");


        Study studyGirl = alena;
        System.out.println("Если есть выбор что читать то я ");
        studyGirl.read();
        System.out.println("----------------------------------");

        Study studyBoy = ivan;
        System.out.println("Если есть выбор что читать то я ");
        studyBoy.read();
        System.out.println("----------------------------------");



    }
}
