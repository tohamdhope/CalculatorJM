package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args)  {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calculatorString = bReader.readLine();

            Calculator calculator = new Calculator();
            String result = calculator.result(calculatorString);
            System.out.println(result);
        }
        catch (CalculatorException | IOException e) {
            System.out.println("Error");
        }
    }
}

