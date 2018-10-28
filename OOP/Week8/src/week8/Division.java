package week8;

public class Division extends BinaryExpression{

    public Division(Expression _left, Expression _right) {
        this.left = _left;
        this.right = _right;
    }

    @Override
    public String toString() {
        String rs;
        if(left instanceof Square || left instanceof Division || 
                left instanceof Numeral || left instanceof Mutiplication) {
            rs = left.toString() + " / ";
        } else {
            rs = "(" + left.toString() + ") / ";
        }
        if(right instanceof Numeral || right instanceof Square || right instanceof Mutiplication) {
            rs += right.toString();
        } else {
            rs += ("(" + right.toString() + ")");
        }
        return rs;
    }

    @Override
    public int evaluate() {
        return left.evaluate() / right.evaluate();
    }
}
