using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[System.Serializable] // эт штука позволяет переводить все двоичный код...
public class PlayerData
{
    public int pointcounter; // счетчик очков
    public int movecounter;  // счетчик ходов
    public int handcounter;  // счетчик раздач

    public PlayerData(MainScript mainScript) // обращаемся к скрипту с переменными и обозначаем для него ключ что ли
    {

        pointcounter = mainScript.pointcounter; //берем оттуда переменные обращаясь по ключу
        movecounter = mainScript.movecounter;
        handcounter = mainScript.handcounter;

    }
}
