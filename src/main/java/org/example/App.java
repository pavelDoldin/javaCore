package org.example;

import java.time.LocalTime;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        int[] arr = new int[]{1,1,1,0,1,0,0,1,1,1};
        ex2(arr, 0);
    }
    public static void ex2(int[] arr, int val){
        /**
         * Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
         */
      int count = 0;
      int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val){
                count ++;
            } else {
                if(count > maxCount){
                    maxCount = count;
                }
                count = 0;
            }
        }
        if (count > maxCount){
            maxCount = count;
        }
        System.out.println(maxCount);
    }
    public static void ex1(){
        /**
         * В консоли запросить имя пользователя. В зависимости от текущего времени, вывести приветствие вида
         * "Доброе утро, <Имя>!", если время от 05:00 до 11:59
         * "Добрый день, <Имя>!", если время от 12:00 до 17:59;
         * "Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
         * "Доброй ночи, <Имя>!", если время от 23:00 до 4:59
         */

        System.out.println("Напишите ваше имя.");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if (hour >= 5 && hour < 12){
            System.out.println("Доброе утро " + name);
        } else if (hour <= 12 && hour < 18) {
            System.out.println("Добрый день " + name);
        } else if (hour >= 18 && hour < 23) {
            System.out.println("Добрый вечер " + name);
        } else {
            System.out.println("Доброй ночи " + name);
        }
    }

}
