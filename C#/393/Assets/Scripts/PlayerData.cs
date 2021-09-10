using System.Collections;
using System.Collections.Generic;
using UnityEngine;

[System.Serializable] // �� ����� ��������� ���������� ��� �������� ���...
public class PlayerData
{
    public int pointcounter; // ������� �����
    public int movecounter;  // ������� �����
    public int handcounter;  // ������� ������

    public PlayerData(MainScript mainScript) // ���������� � ������� � ����������� � ���������� ��� ���� ���� ��� ��
    {

        pointcounter = mainScript.pointcounter; //����� ������ ���������� ��������� �� �����
        movecounter = mainScript.movecounter;
        handcounter = mainScript.handcounter;

    }
}
