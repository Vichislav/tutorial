using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Pause_menu_sc : MonoBehaviour
{
    public static bool GameIsPaused = false;

    public GameObject pauseMenuUI;


    void Update()
    {
        
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            if (GameIsPaused)
            {
                Resume();
            }

            else 
            {
                Pause();
            }
        }  
    
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
