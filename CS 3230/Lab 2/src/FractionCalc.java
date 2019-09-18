import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FractionCalc {

    //REGEX to validate input from user
    static String regex = "-?[0-9]+[ \t]*/[ \t]*-?[0-9]+[ \t]*[+-/\\*][ \t]*-?[0-9]+[ \t]*/[ \t]*-?[0-9]+";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        String expression = getFraction(input);

        ArrayList<String> myList = new ArrayList<>();
        addTokens(expression, myList);

        int num1 = Integer.parseInt(myList.get(0));
        int den1 = Integer.parseInt(myList.get(2));
        int num2 = Integer.parseInt(myList.get(4));
        int den2 = Integer.parseInt(myList.get(6));

        Fraction fraction1 = new Fraction(num1, den1);
        Fraction fraction2 = new Fraction(num2, den2);

        String operator = myList.get(3);
        calculateFraction(fraction1, fraction2, operator);
    }

    /**
     * Receives fraction expression from user and compares it against regular expression. If
     * input is valid expression then expression is returned.
     *
     * @param input
     * @return Sting expression
     */
    private static String getFraction(Scanner input) {
        System.out.print("Please enter a fraction expression i.e., -1/2 - -1/4: ");
        String expression = input.nextLine();

        if (!expression.matches(regex)) {
            System.out.println("Not a valid fraction expression");
            System.exit(0);
        }
        return expression;
    }

    /**
     * Receives a fraction expression and list of tokens
     * Breaks the expression from the input and uses String tokenizer to grab the integers and place them in
     * an arraylist.
     *
     * @param expression
     * @param myList
     */
    private static void addTokens(String expression, ArrayList<String> myList) {
        StringTokenizer st = new StringTokenizer(expression, "-/*\t ", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals(" ") && !token.equals("\t"))
                myList.add(token);
        }
    }

    /**
     * Receives two fractions that are created from the tokens in the array list. Also
     * takes in the operator which is used to calculate the expression
     *
     * @param fraction1
     * @param fraction2
     * @param operator
     */
    private static void calculateFraction(Fraction fraction1, Fraction fraction2, String operator) {
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
    }


}
