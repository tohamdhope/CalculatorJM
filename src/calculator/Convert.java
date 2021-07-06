package calculator;

import java.util.HashMap;
import java.util.Map;

public class Convert {
    private final Map<String, Integer> romanToArabicMap = new HashMap<>();

    private final int[] arabicNumber = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] romanNumber = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public Convert() {
        romanToArabicMap.put("I", 1);
        romanToArabicMap.put("II", 2);
        romanToArabicMap.put("III", 3);
        romanToArabicMap.put("IV", 4);
        romanToArabicMap.put("V", 5);
        romanToArabicMap.put("VI", 6);
        romanToArabicMap.put("VII", 7);
        romanToArabicMap.put("VIII", 8);
        romanToArabicMap.put("IX", 9);
        romanToArabicMap.put("X", 10);
    }

    public boolean isNumberArabic(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isRoman(String string) {
        return romanToArabicMap.containsKey(string);
    }

    public Integer romanToArabicConvert(String string) {
        if (romanToArabicMap.containsKey(string)) {
            return romanToArabicMap.get(string);
        }
        return null;
    }

    public String arabicToRomanConvert(Integer number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicNumber.length; i++) {
            while ((number - arabicNumber[i]) >= 0) {
                number = number - arabicNumber[i];
                result.append(romanNumber[i]);
            }
        }
        return result.toString();
    }

    public boolean checkOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator);
    }
}

