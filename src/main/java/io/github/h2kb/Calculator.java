package io.github.h2kb;

import io.github.h2kb.enums.Operator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {

    private Operator operator;

    private Scanner fileScanner;

    public Calculator(String filePath, String operator) throws FileNotFoundException {
        this.operator = Operator.valueOf(operator);

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
            case SUM:
                return sum();
            case SUB:
                return sub();
            case MULT:
                return mult();
            default:
                System.out.println("Bad operator " + operator + ".");
                return 0;
        }
    }
}
