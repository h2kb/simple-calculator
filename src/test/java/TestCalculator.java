import io.github.h2kb.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class TestCalculator {
    @Test
    public void testCalculateSum() throws FileNotFoundException {
        String filePath = "./src/main/resources/input.txt";
        String operator = "SUM";
        Calculator calculator = new Calculator(filePath, operator);

        int result = calculator.calculate();

        Assert.assertEquals(54, result);
    }

    @Test
    public void testCalculateSub() throws FileNotFoundException {
        String filePath = "./src/main/resources/input.txt";
        String operator = "SUB";
        Calculator calculator = new Calculator(filePath, operator);

        int result = calculator.calculate();

        Assert.assertEquals(-34, result);
    }

    @Test
    public void testCalculateMult() throws FileNotFoundException {
        String filePath = "./src/main/resources/input.txt";
        String operator = "MULT";
        Calculator calculator = new Calculator(filePath, operator);

        int result = calculator.calculate();

        Assert.assertEquals(102000, result);
    }
}
