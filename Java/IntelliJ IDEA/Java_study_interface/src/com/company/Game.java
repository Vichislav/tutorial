package com.company;

public class Game {
                            //Если нам нужно сделать метод запуска игры
    //Boy boy = new Boy();  нам не обязательно создавать отдельные экземпляры классов
    //Girl girl = new Girl(); для каждого из них

    public Player player;  // мы можем обратиться к интерфейсу, который их "объединяет"

    void start (Player player) { // и сказать пускай игрок (который может быть и тем и тем)
        player.Play();          // запускает метод плей (а он у каждого свой)
    }
}
