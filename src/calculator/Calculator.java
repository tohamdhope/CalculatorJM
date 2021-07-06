package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    private int num1;
    private int num2;
    private String operator;

    public int calcExp(int num1, String operation,  int num2) {

        this.num1 = num1;
        this.num2 = num2;
        this.operator = operation;

        int result = 0;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                System.out.println("incorrect input");
        }
        return result;
    }

    public String result(String exception) throws CalculatorException {
        boolean isRomanException;
        Convert parse = new Convert();

        List<String> exceptionItems = Arrays.asList(exception.split(" "));
        if (exceptionItems.size() != 3) {
            throw new CalculatorException();
        }

        if (parse.checkOperator(exceptionItems.get(1))) {
            operator = exceptionItems.get(1);
        } else {
            throw new CalculatorException();
        }

        if (parse.isNumberArabic(exceptionItems.get(0)) && parse.isNumberArabic(exceptionItems.get(2))) {
            num1 = Integer.parseInt(exceptionItems.get(0));
            num2 = Integer.parseInt(exceptionItems.get(2));
            isRomanException = false;
        } else if (parse.isRoman(exceptionItems.get(0)) && parse.isRoman(exceptionItems.get(2))) {
            num1 = parse.romanToArabicConvert(exceptionItems.get(0));
            num2 = parse.romanToArabicConvert(exceptionItems.get(2));
            isRomanException = true;
        } else {
            throw new CalculatorException();
        }

        if (!(num1 >= 1 && num1 <= 10)) {
            throw new CalculatorException();
        }

        if (!(num2 >= 1 && num2 <= 10)) {
            throw new CalculatorException();
        }

        int result = calcExp(num1, operator, num2);

        if (isRomanException) {
            String signature = result < 0 ? "-" : "";
            return signature + parse.arabicToRomanConvert(Math.abs(result));
        }

        return String.valueOf(result);
    }
}