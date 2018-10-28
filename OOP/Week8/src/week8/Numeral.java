package week8;

public class Numeral extends Expression{
    public int value;
    
    public Numeral(int _value) {
        this.value = _value;
    }
    
    public Numeral() {
        this(0);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public int evaluate() {
        return value;
    }
}
