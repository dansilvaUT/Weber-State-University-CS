/**
 * Author: Daniel Silva
 * CS: 3230
 * <p>
 * Lab: 2
 */

public class Fraction {

    private int numerator;
    private int denominator;

    /**
     * Constructs and initializes fraction with a numerator and denominator
     *
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator) {
        int divisor = gcd(numerator, denominator);
        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
    }

    /**
     * Constructs and initializes fraction where denominator is not specified
     *
     * @param numerator
     */
    public Fraction(int numerator) {
        denominator = 1;
    }

    /**
     * Adds two fractons together
     *
     * @param right other fraction to be added
     * @return Fraction object from the two added fractions
     */
    public Fraction add(Fraction right) {
        int num = ((numerator * right.denominator) + (right.numerator * denominator));
        int den = denominator * right.denominator;
        return new Fraction(num, den);
    }

    /**
     * Subtracts two fractions together
     *
     * @param right other fraction to be subtracted
     * @return Fraction object with from the two subtracted fractions
     */
    public Fraction sub(Fraction right) {
        int num = ((numerator * right.denominator) - (right.numerator * denominator));
        int den = denominator * right.denominator;
        return new Fraction(num, den);
    }

    /**
     * Multiplies two fractions together
     *
     * @param right other fraction to be multiplied
     * @return Fraction object from the two multiplied fractions
     */
    public Fraction mult(Fraction right) {
        int num = numerator * right.numerator;
        int den = denominator * right.denominator;
        return new Fraction(num, den);
    }

    /**
     * Divides two fractions together
     *
     * @param right other fraction to be divided from
     * @return Fraction object from divided fractions
     */
    public Fraction div(Fraction right) {
        int num = numerator * right.denominator;
        int den = denominator * right.numerator;
        return new Fraction(num, den);
    }

    /**
     * toString method that prints out fraction
     *
     * @return String that contains numerator and denominator in fraction
     */
    @Override
    public String toString() {
        return String.format("%d / %d", numerator, denominator);
    }

    /**
     * Checks to see if both objects are equal
     *
     * @param obj other object(fraction) being compared to
     * @return
     */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Fraction))
            return false;
        Fraction otherObject = (Fraction) obj;
        return numerator == otherObject.numerator && denominator == otherObject.denominator;
    }

    /**
     * Using Euclid's Algorithm, finds the GCD of both fractions
     *
     * @param u
     * @param v
     * @return
     */
    private int gcd(int u, int v) {
        u = (u < 0) ? -u : u; // make u non-negative
        v = (v < 0) ? -v : v; // make v non-negative
        while (u > 0) {
            if (u < v) {
                int t = u; // swap u and v
                u = v;
                v = t;
            }
            u -= v;
        }
        return v; // the GCD of u and v
    }
}
