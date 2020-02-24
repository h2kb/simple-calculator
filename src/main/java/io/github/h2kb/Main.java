package io.github.h2kb;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String[] rawData = in.nextLine().trim().split("\\s+");
        String filePath;
        String operator;

        try {
            filePath = rawData[0];
            operator = rawData[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InputMismatchException("Invalid arguments: file path or operator.");
        }

        Calculator calculator = new Calculator(filePath, operator);

        System.out.println(calculator.calculate());
    }
}
