package com.shashikhin;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
//        //для тестирования
//        String result;
//        try {
//        System.out.println(calc("3 - 10"));
//        }
//        catch (IOException e) {
//            System.out.println("Неверный ввод");
//        }
    }

    private static boolean IsNumberValid(String inputNumber)
    {
        int number;

        try {
            number = Integer.parseInt(inputNumber);
        }
        catch ( NumberFormatException exception ) {
            return false;
        }

        return number >= 1 && number <= 10;
    }

    public static String calc(String input) throws IOException
    {
        String result;
        byte firstNumber;
        byte secondNumber;

        String[] operators = input.split(" ");

        if (operators.length != 3) throw new IOException();

        if (!IsNumberValid(operators[0]) || !IsNumberValid(operators[2]))
        {
            throw new IOException();
        }

        firstNumber = (byte) Integer.parseInt(operators[0]);
        secondNumber = (byte) Integer.parseInt(operators[2]);

        result = switch (operators[1]) {
            case "+" -> String.valueOf(firstNumber + secondNumber);
            case "-" -> String.valueOf(firstNumber - secondNumber);
            case "*" -> String.valueOf(firstNumber * secondNumber);
            case "/" -> String.valueOf(firstNumber / secondNumber);
            default -> throw new IOException();
        };

        return result;
    }
}