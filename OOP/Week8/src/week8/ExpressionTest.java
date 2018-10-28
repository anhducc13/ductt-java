package week8;

public class ExpressionTest {

    public static void main(String[] args) {
        Expression e1 = new Square(new Numeral(10));
        Expression e2 = new Subtraction(e1, new Numeral(1));
        Expression e3 = new Addition(e2, new Division(new Numeral(2), new Numeral(0)));
        Expression e = new Square(e3);
        System.out.println(e.toString());
        try {
            System.out.println(e.evaluate());
        } catch (ArithmeticException ae) {
            System.out.println("Lỗi chia cho 0");
        }
    }

}
