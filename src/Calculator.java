import java.io.*;
import java.util.Scanner;

public class Calculator {

//    private static final char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
    static int toNumeric(String st) {
        boolean roman = true;
        if (st.charAt(0)>='0' && st.charAt(0)<='9') {
            roman = false;
        }
        if (!roman){
            return Integer.parseInt(st);
        }
        int number=0;
        for (int j = 0;j < st.length(); j++){
            number=number *10 + st.charAt(j)-'0';
        }

        return number;
    }

    public static void main (String[] args) throws Exception {

        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String operation=bf.readLine();
        String text1="";
        String text2="";
        String oper="";
        if (operation.substring(0).contains("-")) {
            text1=operation.substring(0,operation.indexOf("-"));
            text2=operation.substring(operation.indexOf("-")+1);
            oper="-";
        } else if (operation.substring(0).contains("*")) {
            text1=operation.substring(0,operation.indexOf("*"));
            text2=operation.substring(operation.indexOf("*")+1);
            oper="*";
        } else if (operation.substring(0).contains("+")) {
            text1 = operation.substring(0, operation.indexOf("+"));
            text2 = operation.substring(operation.indexOf("+") + 1);
            oper = "+";
        }  else if (operation.substring(0).contains("/")) {
            text1 = operation.substring(0, operation.indexOf("/"));
            text2 = operation.substring(operation.indexOf("/") + 1);
            oper = "/";
        }
        Number num1=new Number(text1);
        Number num2=new Number(text2);
        boolean roman=false;
        if (num1.Roman() && num2.Roman()) {
            roman=true;
        }
        Number num3=new Number (0);
        if (oper.equals("-")) {
            num3 = new Number(num1.ToInt() - num2.ToInt());
        } else if (oper.equals("*")) {
            num3 = new Number(num1.ToInt() * num2.ToInt());
        } else if (oper.equals("+")) {
            num3 = new Number(num1.ToInt() + num2.ToInt());
        } else {
            num3 = new Number(num1.ToInt() / num2.ToInt());
        };
        if (roman){
            out.println(num3.StringValue);
        } else {
            out.println(num3.NumericValue);
        }
        out.close();
    }}

/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(text);

    }

}
*/