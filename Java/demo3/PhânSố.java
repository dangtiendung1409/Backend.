package demo3;

public class PhânSố {
    private int numerator; //tử số
    private int denominator; //mẫu số

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    //constructor
    public PhânSố(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }



    //in phân số
    public void printFraction() {
        System.out.println(numerator + "/" + denominator);
    }

    //rút gọn phân số
    public void simplifyFraction() {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    //tìm ước chung lớn nhất của hai số
    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    //nghịch đảo phân số
    public void invertFraction() {
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    //cộng hai phân số
    public PhânSố add(PhânSố other) {
        int newNumerator = (numerator * other.denominator) + (other.numerator * denominator);
        int newDenominator = denominator * other.denominator;
        PhânSố result = new PhânSố(newNumerator, newDenominator);
        result.simplifyFraction();
        return result;
    }

    //trừ hai phân số
    public PhânSố subtract(PhânSố other) {
        int newNumerator = (numerator * other.denominator) - (other.numerator * denominator);
        int newDenominator = denominator * other.denominator;
        PhânSố result = new PhânSố(newNumerator, newDenominator);
        result.simplifyFraction();
        return result;
    }

    //nhân hai phân số
    public PhânSố multiply(PhânSố other) {
        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        PhânSố result = new PhânSố(newNumerator, newDenominator);
        result.simplifyFraction();
        return result;
    }

    //chia hai phân số
    public PhânSố divide(PhânSố other) {
        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        PhânSố result = new PhânSố(newNumerator, newDenominator);
        result.simplifyFraction();
        return result;
    }
}