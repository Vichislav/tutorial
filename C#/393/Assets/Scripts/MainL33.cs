using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class MainL33 : MonoBehaviour
{
    public int value1;
    public int value2;
    public int value3;
    public int value4;
    public int value5;
    public int value6;
    public int value7;
    public int value8;
    public int value9;
    public Text value1Text;
    public Text value2Text;
    public Text value3Text;
    public Text value4Text;
    public Text value5Text;
    public Text value6Text;
    public Text value7Text;
    public Text value8Text;
    public Text value9Text;

    public int limmit = 9;
    public int pointcounter; // счетчик очков
    public int movecounter;  // счетчик ходов
    public int handcounter;  // счетчик раздач
    public int handcounterlimmit = 5;  // лимит раздач
    public Text pointcounterText;
    public Text movecounterText;
    public Text handcounterText;

    public void Then() //Поиск десяток
    {
        if (value1 % 10 == 0 && value1 != 0) // проверил есть ли десятки 
        {
            pointcounter = pointcounter + (value1 / 10);
            value1 = 0;
        }

        if (value2 % 10 == 0)
        {
            pointcounter = pointcounter + (value2 / 10);
            value2 = 0;
        }

        if (value3 % 10 == 0)
        {
            pointcounter = pointcounter + (value3 / 10);
            value3 = 0;
        }

        if (value4 % 10 == 0)
        {
            pointcounter = pointcounter + (value4 / 10);
            value4 = 0;
        }

        if (value5 % 10 == 0)
        {
            pointcounter = pointcounter + (value5 / 10);
            value5 = 0;
        }

        if (value6 % 10 == 0)
        {
            pointcounter = pointcounter + (value6 / 10);
            value6 = 0;
        }

        if (value7 % 10 == 0)
        {
            pointcounter = pointcounter + (value7 / 10);
            value7 = 0;
        }

        if (value8 % 10 == 0)
        {
            pointcounter = pointcounter + (value8 / 10);
            value8 = 0;
        }

        if (value9 % 10 == 0)
        {
            pointcounter = pointcounter + (value9 / 10);
            value9 = 0;
        }

        movecounter = movecounter + 1;

        value1Text.text = value1.ToString();
        value2Text.text = value2.ToString();
        value3Text.text = value3.ToString();
        value4Text.text = value4.ToString();
        value5Text.text = value5.ToString();
        value6Text.text = value6.ToString();
        value7Text.text = value7.ToString();
        value8Text.text = value8.ToString();
        value9Text.text = value9.ToString();
        pointcounterText.text = pointcounter.ToString();
        movecounterText.text = movecounter.ToString();
    }

    public void WinWindows() //Смена сцены при победе
    {
        if (value3 == 9)
        {
            SceneManager.LoadScene(5);
        }
    }

    public void Button_11_Click() // кнопка начала
    {
        value1 = 0;
        value2 = 0;
        value3 = 0;
        value4 = 0;
        value5 = 0;
        value6 = 0;
        value7 = 9; // значение для переноса
        value8 = 0;
        value9 = 0;

        pointcounter = 0;
        movecounter = 0;
        handcounter = 0;

        value1Text.text = value1.ToString();
        value2Text.text = value2.ToString();
        value3Text.text = value3.ToString();
        value4Text.text = value4.ToString();
        value5Text.text = value5.ToString();
        value6Text.text = value6.ToString();
        value7Text.text = value7.ToString();
        value8Text.text = value8.ToString();
        value9Text.text = value9.ToString();
        pointcounterText.text = pointcounter.ToString();
        movecounterText.text = movecounter.ToString();
        handcounterText.text = handcounter.ToString();
        
    }

    public void Button_1_Click()
    {

        if (value1 % 3 == 0) // раскидал значения
        {
            value2 = value2 + value1 / 3;
            value4 = value4 + value1 / 3;
            value5 = value5 + value1 / 3;
            value1 = 0;
        }
        else
        {
            value2 = value2 + value1 / 2;
            value4 = value4 + value1 / 2;
            value5 = value5 + (value1 % 2);
            value1 = 0;

        }

        Then();

        WinWindows();
    }

    public void Button_2_Click()
    {

        if (value2 % 3 == 0) // раскидал значения
        {
            value1 = value1 + value2 / 3;
            value3 = value3 + value2 / 3;
            value5 = value5 + value2 / 3;
            value2 = 0;
        }
        else
        {
            value1 = value1 + value2 / 2;
            value3 = value3 + value2 / 2;
            value5 = value5 + (value2 % 2);
            value2 = 0;
        }

        Then();

        WinWindows();
    }

    public void Button_3_Click()
    {


        if (value3 % 3 == 0) // раскидал значения
        {
            value2 = value2 + value3 / 3;
            value6 = value6 + value3 / 3;
            value5 = value5 + value3 / 3;
            value3 = 0;
        }
        else
        {
            value2 = value2 + value3 / 2;
            value6 = value6 + value3 / 2;
            value5 = value5 + (value3 % 2);
            value3 = 0;

        }

        Then(); // проверяю десятки 
        WinWindows();


    }

    public void Button_4_Click()
    {


        if (value4 % 3 == 0) // раскидал значения
        {
            value1 = value1 + value4 / 3;
            value7 = value7 + value4 / 3;
            value5 = value5 + value4 / 3;
            value4 = 0;
        }
        else
        {
            value1 = value1 + value4 / 2;
            value7 = value7 + value4 / 2;
            value5 = value5 + (value4 % 2);
            value4 = 0;

        }

        Then();
        WinWindows();

    }

    public void Button_5_Click() // центральная кнопка
    {


        if (value5 % 8 == 0) // раскидал значения
        {
            value1 = value1 + value5 / 8;
            value2 = value2 + value5 / 8;
            value3 = value3 + value5 / 8;
            value4 = value4 + value5 / 8;
            value6 = value6 + value5 / 8;
            value7 = value7 + value5 / 8;
            value8 = value8 + value5 / 8;
            value9 = value9 + value5 / 8;
            value5 = 0;
        }
        

        Then();
        WinWindows();

    }

    public void Button_6_Click()
    {


        if (value6 % 3 == 0) // раскидал значения
        {
            value3 = value3 + value6 / 3;
            value9 = value9 + value6 / 3;
            value5 = value5 + value6 / 3;
            value6 = 0;
        }
        else
        {
            value3 = value3 + value6 / 2;
            value9 = value9 + value6 / 2;
            value5 = value5 + (value6 % 2);
            value6 = 0;

        }

        Then();
        WinWindows();

    }

    public void Button_7_Click()
    {


        if (value7 % 3 == 0) // раскидал значения
        {
            value4 = value4 + value7 / 3;
            value8 = value8 + value7 / 3;
            value5 = value5 + value7 / 3;
            value7 = 0;
        }
        else
        {
            value4 = value4 + value7 / 2;
            value8 = value8 + value7 / 2;
            value5 = value5 + (value7 % 2);
            value7 = 0;

        }

        Then();
        WinWindows();

    }

    public void Button_8_Click()
    {


        if (value8 % 3 == 0) // раскидал значения
        {
            value7 = value7 + value8 / 3;
            value9 = value9 + value8 / 3;
            value5 = value5 + value8 / 3;
            value8 = 0;
        }
        else
        {
            value7 = value7 + value8 / 2;
            value9 = value9 + value8 / 2;
            value5 = value5 + (value8 % 2);
            value8 = 0;

        }

        Then();
        WinWindows();

    }

    public void Button_9_Click()
    {


        if (value9 % 3 == 0) // раскидал значения
        {
            value6 = value6 + value9 / 3;
            value8 = value8 + value9 / 3;
            value5 = value5 + value9 / 3;
            value9 = 0;
        }
        else
        {
            value6 = value6 + value9 / 2;
            value8 = value8 + value9 / 2;
            value5 = value5 + (value9 % 2);
            value9 = 0;

        }

        Then();
        WinWindows();

    }

    public void Button_10_Click() //Раздача
    {
        if (handcounter <= handcounterlimmit)
        {

            value7 = value7 + 9; // задал приращение
            
            

            if (value1 % 10 == 0) // проверил есть ли десятки 
            {
                pointcounter = pointcounter + (value1 / 10);
                value1 = 0;
            }

            if (value2 % 10 == 0)
            {
                pointcounter = pointcounter + (value2 / 10);
                value2 = 0;
            }

            if (value3 % 10 == 0)
            {
                pointcounter = pointcounter + (value3 / 10);
                value3 = 0;
            }

            if (value4 % 10 == 0)
            {
                pointcounter = pointcounter + (value4 / 10);
                value4 = 0;
            }


            if (value5 % 10 == 0)
            {
                pointcounter = pointcounter + (value5 / 10);
                value5 = 0;
            }


            if (value6 % 10 == 0)
            {
                pointcounter = pointcounter + (value6 / 10);
                value6 = 0;
            }

            if (value7 % 10 == 0)
            {
                pointcounter = pointcounter + (value7 / 10);
                value7 = 0;
            }

            if (value8 % 10 == 0)
            {
                pointcounter = pointcounter + (value8 / 10);
                value8 = 0;
            }

            if (value9 % 10 == 0)
            {
                pointcounter = pointcounter + (value9 / 10);
                value9 = 0;
            }

            handcounter = handcounter + 1;

            value1Text.text = value1.ToString();
            value2Text.text = value2.ToString();
            value3Text.text = value3.ToString();
            value4Text.text = value4.ToString();
            value5Text.text = value5.ToString();
            value6Text.text = value6.ToString();
            value7Text.text = value7.ToString();
            value8Text.text = value8.ToString();
            value9Text.text = value9.ToString();
            pointcounterText.text = pointcounter.ToString();
            handcounterText.text = handcounter.ToString();

            WinWindows();
        }
    }

    public void Button_12_Click() //Заново
    {
        value1Text.text = "";
        value2Text.text = "";
        value3Text.text = "";
        value4Text.text = "";
        value5Text.text = "";
        value6Text.text = "";
        value7Text.text = "";
        value8Text.text = "";
        value9Text.text = "";
        movecounterText.text = "";
        pointcounterText.text = "";
        handcounterText.text = "";

    }

    public void Button_13_Click() //Смена сцены к правилам
    {
                
            SceneManager.LoadScene(2);
        
    }

    public void Button_14_Click() //Смена сцены к меню
    {

        SceneManager.LoadScene(0);

    }

}


