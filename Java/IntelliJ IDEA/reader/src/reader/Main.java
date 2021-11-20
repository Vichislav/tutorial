package reader;

import java.io.*;


class Program {

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("notes4.txt"))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {

                System.out.println(s);
                //разделение строки на отдельные подстроки(не пустая связанная часть строки)
                //(критерий, указываем в "", в данном случае пробел)
                String[] numbers = s.split(" ");
                double a = Double.parseDouble(numbers[0]);
                double b = Double.parseDouble(numbers[1]);
                double c = Double.parseDouble(numbers[2]);
                double sum = a + b + c;
                System.out.println(a + " + " + b + " + " + c + " = " + sum);
                System.out.println("s.length() == " + s.length());
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