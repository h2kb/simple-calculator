package io.github.h2kb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private static String filePath;

    private static String operator;

    private static Scanner fileScanner;

    private static int result;

    public static void initData() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String[] rawData = in.nextLine().trim().split("\\s+");

        try {
            filePath = rawData[0];
            operator = rawData[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("Invalid arguments: file path or operator.");
        }

        try {
            fileScanner = new Scanner(new File(filePath));
        } catch (IOException e) {
            throw new FileNotFoundException("File not found.");
        }

        result = Integer.parseInt(fileScanner.nextLine());
    }

    private static void sum() {
        while (fileScanner.hasNextLine()) {
            result += Integer.parseInt(fileScanner.nextLine());
        }
    }

    private static void sub() {
        while (fileScanner.hasNextLine()) {
            result -= Integer.parseInt(fileScanner.nextLine());
        }
    }

    private static void mult() {
        while (fileScanner.hasNextLine()) {
            result *= Integer.parseInt(fileScanner.nextLine());
        }
    }

    public static void calculate() {
        switch (operator) {
            case "SUM":
                sum();
                break;
            case "SUB":
                sub();
                break;
            case "MULT":
                mult();
                break;
            default:
                result = 0;
                System.out.println("Bad operator " + operator + ".");
                break;
        }
    }

    public static void closeData() {
        fileScanner.close();
    }

    public static void main(String[] args) throws IOException {
        initData();
        calculate();
        closeData();

        System.out.println(result);
    }
}
