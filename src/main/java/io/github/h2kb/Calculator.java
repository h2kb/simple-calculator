package io.github.h2kb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] rawData = in.nextLine().trim().split("\\s+");
        String filePath;
        String operator;
        int result;
        Scanner fileScanner;

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

        while (fileScanner.hasNextLine()) {
            if (operator.equals("SUM")) {
                result += Integer.parseInt(fileScanner.nextLine());
            } else if (operator.equals("SUB")) {
                result -= Integer.parseInt(fileScanner.nextLine());
            } else if (operator.equals("MULT")) {
                result *= Integer.parseInt(fileScanner.nextLine());
            } else {
                result = 0;
                System.out.println("Bad operator " + operator + ".");
                break;
            }
        }

        fileScanner.close();

        System.out.println(result);
    }
}
