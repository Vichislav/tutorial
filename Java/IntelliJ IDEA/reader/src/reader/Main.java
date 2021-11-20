package reader;

import java.io.*;

class Program {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("notes4.txt"))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {

                System.out.println(s);
                char[] chArray = s.toCharArray(); // преобразовали строку в массив
                double a = Double.parseDouble(Character.toString(chArray [0])); //ну такие дела ...
                double b = Double.parseDouble(Character.toString(chArray [2])); // в общем перевод в дабл из чара который строка...
                double c = Double.parseDouble(Character.toString(chArray [4]));
                double sum = a + b + c;
                System.out.println(a + "+" + b + "+" + c + "=" + sum);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

       /* String str = "1 000 000 000";
        //преобразовываем строку в массив
        char[] chArray = str.toCharArray();
        //перебираем все элементы массива
        for(int i = 0; i<chArray.length; i++){
            //находим пробел
            if(chArray[i] == ' '){
                //заменяем на точку
                chArray[i] = '.';

            }
        }
        //выводим результат
        System.out.println(chArray);
    } */
    }
}