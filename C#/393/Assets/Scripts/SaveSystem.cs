using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.IO; // используем когда надо работать с файлами в системе
using System.Runtime.Serialization.Formatters.Binary; // эт я так понял, что бы с двоичным кодом работать...

public static class SaveSystem 
{
    public static void SavePlayer(MainScript mainScript) 
    {
        BinaryFormatter formatter = new BinaryFormatter(); // создаем двоичный форматер (я хз чего здесь происходт)
        string path = Application.persistentDataPath + "/playerSave"; // указываем путь через команду апликейшен где будет файл и называем его
        FileStream stream = new FileStream(path, FileMode.Create); // создаем файловый поток, ну тут я все...

        PlayerData data = new PlayerData(mainScript);

        formatter.Serialize(stream, data);
        stream.Close();

    }

    public static PlayerData LoadPlayer() 
    {
        string path = Application.persistentDataPath + "/playerSave";
        if (File.Exists(path))
        {
            BinaryFormatter formatter = new BinaryFormatter();
            FileStream stream = new FileStream(path, FileMode.Open);

            PlayerData data = formatter.Deserialize(stream) as PlayerData; //присваеваем данным игрока то что перевел из двоичного когда форматер, когда мы скормили ему поток...
            stream.Close(); // поток нужно всегда закрывать
            return data;
        }
        else 
        {
            Debug.LogError("Save file not found in" + path);
            return null;
         }
    }
}

