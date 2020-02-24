package io.github.h2kb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    private String operator;

    private Scanner fileScanner;

    public void initData() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String[] rawData = in.nextLine().trim().split("\\s+");
        String filePath;

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
    }

    private int sum() {
        int result = Integer.parseInt(fileScanner.nextLine());

        while (fileScanner.hasNextLine()) {
            result += Integer.parseInt(fileScanner.nextLine());
        }

        return result;
    }

    private int sub() {
        int result = Integer.parseInt(fileScanner.nextLine());

        while (fileScanner.hasNextLine()) {
            result -= Integer.parseInt(fileScanner.nextLine());
        }

        return result;
    }

    private int mult() {
        int result = Integer.parseInt(fileScanner.nextLine());

        while (fileScanner.hasNextLine()) {
            result *= Integer.parseInt(fileScanner.nextLine());
        }

        return result;
    }

    public int calculate() {
        switch (operator) {
            case "SUM":
                return sum();
            case "SUB":
                return sub();
            case "MULT":
                return mult();
            default:
                System.out.println("Bad operator " + operator + ".");
                return 0;
        }
    }

    public void closeData() {
        fileScanner.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Calculator calculator = new Calculator();

        calculator.initData();
        int result = calculator.calculate();
        calculator.closeData();

        System.out.println(result);
    }
}
