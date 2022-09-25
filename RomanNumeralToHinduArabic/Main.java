package RomanNumeralToHinduArabic;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();

        String romanNum;
        for(int i=0;i<100;i++){
            System.out.print("\nInput Roman Numeral: ");
            try {
                romanNum = sc.nextLine();
                converter.convert(romanNum.toUpperCase());
            } catch (NullPointerException e) {
                System.out.println("Skipping Empty Input");
            }         
        }
        sc.close();
    }
}