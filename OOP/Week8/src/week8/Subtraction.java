package week8;

public class Subtraction extends BinaryExpression {

    public Subtraction(Expression _left, Expression _right) {
        this.left = _left;
        this.right = _right;
    }

    @Override
    public String toString() {
        return left.toString() + " - " + right.toString();
    }

    @Override
    public int evaluate() {
        return left.evaluate() - right.evaluate();
    }

}
