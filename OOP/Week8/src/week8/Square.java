package week8;

public class Square extends Expression{
    public Expression expression;
    
    public Square(Expression _expression) {
        this.expression = _expression;
    }

    @Override
    public String toString() {
        if(expression instanceof Numeral) {
            return expression.toString() + "^2";
        } else {
            return "(" + expression.toString() + ")^2";
        }
    }

    @Override
    public int evaluate() {
        return new Mutiplication(expression, expression).evaluate();
    }
    
    
}
