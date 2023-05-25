package demo3;

public class Main {
    public static void main(String[] args) {
        PhânSố fraction1 = new PhânSố(3, 4);
        PhânSố fraction2 = new PhânSố(1, 2);

        //in phân số
        fraction1.printFraction();

        //rút gọn phân số
        fraction1.simplifyFraction();
        fraction1.printFraction();

        //nghịch đảo phân số
        fraction1.invertFraction();
        fraction1.printFraction();

        //cộng hai phân số
        PhânSố sum = fraction1.add(fraction2);
        sum.printFraction();

        //trừ hai phân số
        PhânSố difference = fraction1.subtract(fraction2);
        difference.printFraction();

        //nhân hai phân số
        PhânSố product = fraction1.multiply(fraction2);
        product.printFraction();

        //chia hai phân số
        PhânSố quotient = fraction1.divide(fraction2);
        quotient.printFraction();
    }
}