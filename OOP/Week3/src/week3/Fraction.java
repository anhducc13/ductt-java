package week3;

public class Fraction {
    private int numerator;
    private int denominator;

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

    // Hàm khởi tạo có tham số
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1,1);
    }
    
    // Kiểm tra phân số (mẫu khác 0)
    public boolean isFraction() {
        return (denominator != 0);
    }
    
    // Phép lấy phân số đối
    public Fraction FracArgu() {
        return new Fraction(-numerator,denominator);
    }
    
    // Phép lấy nghịch đảo
    public Fraction Reciprocal() {
        return new Fraction(denominator,numerator);
    }
    
    // Phép cộng
    public Fraction Add (Fraction otherFrac) {
        int nume = numerator * otherFrac.denominator + denominator * otherFrac.numerator;
        int deno = denominator * otherFrac.denominator;
        return new Fraction(nume,deno);
    }
    
    // Phép trừ
    public Fraction Abstract(Fraction otherFrac) {
        return this.Add(otherFrac.FracArgu());
    }
    
    // Phép nhân
    public Fraction Mutiply (Fraction otherFrac) {
        return new Fraction(numerator * otherFrac.numerator,denominator * otherFrac.denominator);
    }
    
    // Phép chia
    public Fraction Division (Fraction otherFrac) {
        return this.Mutiply(otherFrac.Reciprocal());
    }
    
    // so sánh bằng 2 phân số
    public boolean equals (Fraction otherFrac) {
        return (this.Abstract(otherFrac).numerator == 0);
    }
}
