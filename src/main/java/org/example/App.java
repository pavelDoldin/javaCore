package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    public static void main( String[] args ) {
//        String s = "hi";
//        int n = 100;
//        ex13(s, n);


    }

    public static void ex13(String s, int n){
        /**
         * Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод,
         * который запишет эту строку в простой текстовый файл, обработайте исключения.
         */
        String filePath = "test.txt";
        String s1 = repeatString(s, n);
        writeToFile(s1, filePath);

    }
    static void writeToFile(String s, String filePath){
//        File file = new File(filePath);
//        if (!file.exists()) {
//            try {
//                file.createNewFile();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }

        try {
            Logger logger = Logger.getAnonymousLogger();
            FileHandler fileHandler = new FileHandler("log.txt", true);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            try (FileWriter fileWriter = new FileWriter(filePath, false)) {
                fileWriter.write(s);
                fileWriter.flush();
                logger.log(Level.INFO, "Все создалось и записалось.");
            } catch (Exception e) {
                e.printStackTrace();
                logger.log(Level.WARNING, e.getMessage());
            }
            fileHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static String repeatString(String s, int n){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
    public static boolean ex12(String s) {
        // Напишите метод, который принимает на вход строку (String)
        // и определяет, является ли строка палиндромом (возвращает boolean значение).

//        StringBuilder stringBuilder = new StringBuilder(s);
//        stringBuilder = stringBuilder.reverse();
//        if (s.equals(stringBuilder.toString())) {
//            return true;
//        } else {
//            return false;
//        }

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
    public static String ex11(String s) {
        //Напишите метод, который сжимает строку.
        //Пример: вход aaaabbbcdd.
        //Результат: a4b3cd2

        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                count++;
            } else {
                stringBuilder.append(s.charAt(i-1));
                if (count != 1){
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }
        stringBuilder.append(s.charAt(s.length()-1));
        if (count != 1){
            stringBuilder.append(count);
        }

        return stringBuilder.toString();
    }
    public static String ex10(char c1, char c2, int n){
        /**
         * Дано четное число N (>0) и символы c1 и c2.
         * Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
         * Ответ: c1c2c1…c2 (всего N символов)
         */
        if (n <= 0 || n % 2 == 1){
            return String.format("%d не должно быть отрицательным, нолём или нечётным.", n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            stringBuilder.append(c1);
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }
    public static double ex9() {
        Scanner scanner = new Scanner(System.in);
        double res;

        System.out.println("Введите первое число.");
        double firstNumber = scanner.nextInt();

        System.out.println("Введите операцию деление /\n" +
                "   \t умножение *\n" +
                "   \t деление с остатком %\n" +
                "   \t сложение +\n" +
                "   \t вычитание -");
        String c = scanner.next();

        System.out.println("Введите второе число.");
        double secondNumber = scanner.nextInt();

        if (c.equals("/")) {
            res = firstNumber / secondNumber;
        } else if (c.equals("*")) {
            res = firstNumber * secondNumber;
        } else if (c.equals("+")) {
            res = firstNumber + secondNumber;
        } else {
            res = firstNumber - secondNumber;
        }
        return res;
    }
    public static void ex8() {
        //Вывести все простые числа от 1 до 1000
        for (int i = 2; i < 1000; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i / 2 + 1; j++) {
                if (i % j == 0){
                    isPrime = false;
                }
            }
            if (isPrime) System.out.println(i);
        }

    }
    public static String ex7(int number) {
        /**
         * n! (произведение чисел от 1 до n)
         */
        if (number <= 0) {
            return String.format("%d число не может быть отрицательным.", number);
        } else {
            int factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            return String.format("Факториал числа %d равен %d", number, factorial);
        }
    }

    public static int ex6() {
        /**
         * Вычислить n-ое треугольного число(сумма чисел от 1 до n).
         */
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int rez = 0;
        //rez = number * (number + 1) / 2;
        for (int i = 1; i <= number; i++) {
            rez += i;
        }
        return rez;
    }
    public static double ex5(int a, int b){
        /**
         * Реализовать функцию возведения числа а в степень b. a, b из Z.
         * Сводя количество выполняемых действий к минимуму.
         * Пример 1: а = 3, b = 2, ответ: 9
         * Пример 2: а = 2, b = -2, ответ: 0.25
         * Пример 3: а = 3, b = 0, ответ: 1
         */
        if (b == 0) {
            return 1;
        }
        if (a == 0 || a == 1){
            return a;
        }
        double a1 = a;
        double b1 = b;
        if (b < 0){
            a1 = 1.0/a;
            b1 = -b;
        }
        double res = a1;
        for (int i = 0; i < b1-1; i++) {
            res *= a1;
        }

        return res;
    }
    public static String ex4(String str){
        /**
         * Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.
         */
        String[] temp = str.split(" ");
        String res = "";
        for (int i = temp.length - 1; i >= 0; i--) {
            res += temp[i] + " ";
        }
        return res;
    }
    public static void ex3(int[] arr, int val){
        /**
         * Дан массив {3, 2, 5, 3} и число val = 3
         * Если в массиве есть числа, равные значению, нужно перенести эти элементы в конец массива
         */
        int[] res = new int[arr.length];
        Arrays.fill(res, val);
        for (int i = 0, j = 0; i < res.length ; i++) {
            if (arr[i] != val){
                res[j] = arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(res));
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
