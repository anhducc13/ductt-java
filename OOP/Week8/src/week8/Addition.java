package week8;

public class Addition extends BinaryExpression{
    
    public Addition(Expression _left, Expression _right) {
        this.left = _left;
        this.right = _right;
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }

    @Override
    public int evaluate() {
        return left.evaluate() + right.evaluate();
    }
    
    
    
}
