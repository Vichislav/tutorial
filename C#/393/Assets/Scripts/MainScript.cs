using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;



public class MainScript : MonoBehaviour
  {
    public int value1;
    public int value2;
    public int value3;
    public int value4;
    public Text value1Text;
    public Text value2Text;
    public Text value3Text;
    public Text value4Text;

    public int pointcounter; // счетчик очков
    public int movecounter;  // счетчик ходов
    public int handcounter;  // счетчик раздач
    public int handcounterlimmit = 5;  // лимит раздач
    public Text pointcounterText; 
    public Text movecounterText;  
    public Text handcounterText;

    public static bool GameIsPaused = false;

    public GameObject pauseMenuUI;

    public void WinWindows()
    {
        if (pointcounter >= 5)
        {
            SceneManager.LoadScene(5);
        }
        
        //if (pointcounter >= 5)
        //{
        //    if (GameIsPaused)
        //    {
        //        Resume();
        //    }

        //    else
        //    {
        //        Pause();
        //    }
        //}

    }
    public void Then() 
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

        movecounter = movecounter + 1;

        value1Text.text = value1.ToString();
        value2Text.text = value2.ToString();
        value3Text.text = value3.ToString();
        value4Text.text = value4.ToString();
        pointcounterText.text = pointcounter.ToString();
        movecounterText.text = movecounter.ToString();
    }
    public void ToScene0()
    {
        SceneManager.LoadScene(0);
    }

    public void ToScene1() 
    {
        SceneManager.LoadScene(1);
    }
    
    public void ToScene2()
    {
        SceneManager.LoadScene(2);
    }
    public void ToScene3()
    {
        SceneManager.LoadScene(3);
    }
    public void ToScene4()
    {
        SceneManager.LoadScene(4);
    }

    public void ToScene5()
    {
        SceneManager.LoadScene(5);
    }
    public void ToScene6()
    {
        SceneManager.LoadScene(6);
    }
    public void ToScene7()
    {
        SceneManager.LoadScene(7);
    }
    public void Button_6_Click() // кнопка начала
    {
        value1 = 3;
        value2 = 3;
        value3 = 3;
        value4 = 3;

        pointcounter = 0;
        movecounter = 0;
        handcounter = 0;

        value1Text.text = value1.ToString();
        value2Text.text = value2.ToString();
        value3Text.text = value3.ToString();
        value4Text.text = value4.ToString();
        pointcounterText.text = pointcounter.ToString();
        movecounterText.text = movecounter.ToString();
        handcounterText.text = handcounter.ToString();

        //value1 = PlayerPrefs.GetInt(value1Text.text); //сохранили данные
        //value2 = PlayerPrefs.GetInt(value2Text.text);
        //value3 = PlayerPrefs.GetInt(value3Text.text);
        //value4 = PlayerPrefs.GetInt(value4Text.text);


    }

    public void Button_1_Click()
    {
      
        if (value1 % 3 == 0) // раскидал значения
        {
            value2 = value2 + value1 / 3;
            value3 = value3 + value1 / 3;
            value4 = value4 + value1 / 3;
            value1 = 0;
        }
        else
        {
            value2 = value2 + value1 / 2;
            value3 = value3 + value1 / 2;
            value4 = value4 + (value1 % 2);
            value1 = 0;

        }

        Then();

        //SaveSystem.SavePlayer(this);

        WinWindows();
        


    }

    public void Button_2_Click()
    {
       

        if (value2 % 3 == 0) // раскидал значения
        {
            value1 = value1 + value2 / 3;
            value3 = value3 + value2 / 3;
            value4 = value4 + value2 / 3;
            value2 = 0;
        }
        else
        {
            value1 = value1 + value2 / 2;
            value4 = value4 + value2 / 2;
            value3 = value3 + (value2 % 2);
            value2 = 0;

        }

        Then();
        WinWindows();
        

    }

    public void Button_3_Click()
    {


        if (value3 % 3 == 0) // раскидал значения
        {
            value1 = value1 + value3 / 3;
            value2 = value2 + value3 / 3;
            value4 = value4 + value3 / 3;
            value3 = 0;
        }
        else
        {
            value1 = value1 + value3 / 2;
            value4 = value4 + value3 / 2;
            value2 = value2 + (value3 % 2);
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
            value2 = value2 + value4 / 3;
            value3 = value3 + value4 / 3;
            value4 = 0;
        }
        else
        {
            value3 = value3 + value4 / 2;
            value2 = value2 + value4 / 2;
            value1 = value1 + (value4 % 2);
            value4 = 0;

        }

        Then();
        WinWindows();
        
    }

    
    public void Button_5_Click() //Раздача
    {
        if (handcounter <= handcounterlimmit)
        {

            value1 = value1 + 3; // задал приращение
            value2 = value2 + 3;
            value3 = value3 + 3;
            value4 = value4 + 3;

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

            handcounter = handcounter+1;

            value1Text.text = value1.ToString();
            value2Text.text = value2.ToString();
            value3Text.text = value3.ToString();
            value4Text.text = value4.ToString();
            pointcounterText.text = pointcounter.ToString();
            handcounterText.text = handcounter.ToString();
            //SaveSystem.SavePlayer(this);

            WinWindows();
            

        }
    }
    public void Button_7_Click()
    {
        value1Text.text = "";
        value2Text.text = "";
        value3Text.text = "";
        value4Text.text = "";
        movecounterText.text = "";
        pointcounterText.text = "";
        handcounterText.text = "";

    }
    

    public void SavePlayer()
    {
        SaveSystem.SavePlayer(this);
    }

    public void LoadPlayer()
    {
        PlayerData data = SaveSystem.LoadPlayer();

        movecounter = data.movecounter;
        pointcounter = data.pointcounter;
        handcounter = data.handcounter;

    }

    void Resume()
    {
        pauseMenuUI.SetActive(false);
        Time.timeScale = 1f; //восстанавливаем ход времени
        GameIsPaused = false;
    }
    void Pause()
    {
        pauseMenuUI.SetActive(true);
        Time.timeScale = 0f; //останавливаем время, мне это по идее нафиг не надо ну так на всякий
        GameIsPaused = true;

    }
}
