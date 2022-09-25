package RomanNumeralToHinduArabic;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Converter {
    HashMap<String, Integer> ref;
    StringBuilder stringBuilder;
    public Converter(){
        ref = new HashMap<String, Integer>() {{
            put("M", 1000);
            put("D", 500);
            put("C", 100);
            put("L", 50);
            put("X", 10);
            put("V", 5);
            put("I", 1);
        }};
        stringBuilder = new StringBuilder();
    }

    public int convert(String romanNum){
        int equivalent = 0;
        String regexComplete = "^(?:M*CM(?:CD(?:XC|(?:XL(?:IX|(?:IV|V?I{0,3}))|L?(?:IX|X{0,3}(?:IV|V?I{0,3}))))|D?(?:C{0,3}XC(?:IX|(?:IV|V?I{0,3}))|C{0,3}(?:XL(?:IX|(?:IV|V?I{0,3}))|L?(?:IX|X{0,3}(?:IX|(?:IV|V?I{0,3}))))))|M*(?:CD(?:XC(?:IX|(?:IV|V?I{0,3}))|(?:XL(?:IX|(?:IV|V?I{0,3}))|L?(?:IX|X{0,3}(?:IV|V?I{0,3}))))|D?(?:C{0,3}XC(?:IX|(?:IV|V?I{0,3}))|C{0,3}(?:XL(?:IX|(?:IV|V?I{0,3}))|L?(?:IX|X{0,3}(?:IX|(?:IV|V?I{0,3})))))))$";

        if (Pattern.matches(regexComplete,romanNum)==false){
            System.out.println("Format Must Follow Rules of Roman Numeration");
            return 0;
        }

        stringBuilder.delete(0,stringBuilder.length());
        String reversedStr = stringBuilder.append(romanNum).reverse().toString();

        String[] choppedStr = reversedStr.split("");
        int lastValue = 0;
        for (String str: choppedStr){
            int newValue = ref.get(str);
            if (lastValue <= newValue){
                equivalent += newValue;
            } else {
                equivalent -= newValue;
            }
            lastValue = newValue;
        }
        System.out.println("The Value of " + romanNum + " is " + equivalent);
        return equivalent;
    }
}

//String regexThousands = "^(?:M*CM|M*(?:CD|D?C{0,3}))$";
//String regexHundreds = "^(?:C{0,3}XC|C{0,3}(?:XL|L?X{0,3}))$";
//String regexTens = "^(?:X{0,3}IX|X{0,3}(?:IV|V?I{0,3}))$";
