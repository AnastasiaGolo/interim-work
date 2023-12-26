import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator {
    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    public static void main(String[] args) {
        // Configure logger
        try {
            FileHandler fileHandler = new FileHandler("calculator.log");
            fileHandler.setFormatter(new SimpleFormatter());

            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calculator calculator = new Calculator();
        double num1 = 10.5;
        double num2 = 5.5;

        double additionResult = calculator.addition(num1, num2);
        LOGGER.info("Addition Result: " + additionResult);

        double multiplicationResult = calculator.multiplication(num1, num2);
        LOGGER.info("Multiplication Result: " + multiplicationResult);

        double divisionResult = calculator.division(num1, num2);
        LOGGER.info("Division Result: " + divisionResult);
    }

    public double addition(double num1, double num2) {
        return num1 + num2;
    }

    public double multiplication(double num1, double num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            LOGGER.warning("Division by zero attempted");
            throw new ArithmeticException("Division by zero");
        }
    }
}