package com.company;

public class School { // нам нужно передать сюда студентов

    Study study;      // и мы, не предаем их каждого, а вызываем интрефейс (Study)
                      // связывающий их по определенному фанкционалу (который нам и нужен!)
                      // не все! методы а только то что нужно

    void start (Study study) {  // реализуем нужный нам функционал
        study.read();
    }
}
