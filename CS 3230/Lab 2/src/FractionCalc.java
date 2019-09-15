import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FractionCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //REGEX to validate input from user
        String regex = "-?[0-9]+[ \t]*/[ \t]*-?[0-9]+[ \t]*[+-/\\*][ \t]*-?[0-9]+[ \t]*/[ \t]*-?[0-9]+";
        System.out.print("Please enter a fraction expression i.e., -1/2 - -1/4: ");
        String expression = input.nextLine().trim();

        if (!expression.matches(regex)) {
            System.out.print("Not a valid fraction expression");
        }

        ArrayList<String> myList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(expression, " \t/", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals(" ") && !token.equals("\t"))
                myList.add(token);
        }

        //Used for testing
        //for (String i : myList)
        //  System.out.print(i + ",");

        int num1 = Integer.parseInt(myList.get(0));
        int den1 = Integer.parseInt(myList.get(2));
        int num2 = Integer.parseInt(myList.get(4));
        int den2 = Integer.parseInt(myList.get(6));

        Fraction fraction1 = new Fraction(num1, den1);
        Fraction fraction2 = new Fraction(num2, den2);

        String operator = myList.get(3);
        switch (operator) {
            case "+":
                System.out.println(fraction1.add(fraction2));
                break;
            case "-":
                System.out.println(fraction1.sub(fraction2));
                break;
            case "*":
                System.out.println(fraction1.mult(fraction2));
                break;
            case "/":
                System.out.println(fraction1.div(fraction2));
                break;
        }
        //TODO clean up code with private static methods? Also use equals method?
    }
}
