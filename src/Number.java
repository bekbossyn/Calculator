import java.util.LinkedHashMap;
import java.util.Map;

public class Number {

    public Integer NumericValue;
    public String StringValue;
    public boolean roman;

    Number(String stValue){
        this.StringValue=stValue;
        this.roman=Roman();
        this.NumericValue = ToInt();
    }

    Number (int intValue){
        this.NumericValue=intValue;
        this.StringValue=ToRoman();
        this.roman=Roman();
    }

    public boolean Roman(){
        int pos=0;
        if (this.StringValue.length()==0){
            return false;
        }
        if (this.StringValue.charAt(0)=='-'){
            pos=1;
        }
        return this.StringValue.charAt(pos)=='X' || this.StringValue.charAt(pos)=='V' || this.StringValue.charAt(pos)=='I';
    }


    public static String integerToRoman2(int number) {

        final int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        final String[] romanLiterals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder s = new StringBuilder();
        if (number < 0){
            number = -number;
            s.append('-');
        }
        if( number==0){
            return "";
        }
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                s.append(romanLiterals[i]);
            }
        }
        return s.toString();
    }

    public static int romanToInteger2(String s) {

        Map<Character, Integer> values = new LinkedHashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i+1 == s.length() || values.get(s.charAt(i)) >= values.get(s.charAt(i + 1))) {
                number += values.get(s.charAt(i));
            } else {
                number -= values.get(s.charAt(i));
            }
        }
        return number;
    }

    public int ToInt(){
//        System.out.println(Integer.parseInt(this.StringValue));
        roman = this.roman;
        if (roman){
            return romanToInteger2(this.StringValue);
        } else {
            return Integer.parseInt(this.StringValue);
        }
    }

    public String ToRoman(){
        return integerToRoman2(this.NumericValue);
    }

    public String operation(){

       return "";
    }

}
