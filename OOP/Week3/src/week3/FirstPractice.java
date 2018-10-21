package week3;

public class FirstPractice {
    
    // Tìm UCLN
    int GCD (int num1, int num2) {
        int a = (num1 >= 0) ? num1 : -num1;
        int b = (num2 >= 0) ? num2 : -num2;
        
        if (a == 0 || b == 0) {
            return (a >= b) ? a : b;
        }
        
        while (a != b) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
    
    // Fibonaxi đệ quy
    long Fibonaxi (int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return (Fibonaxi(n-1) + Fibonaxi(n-2));
    }
    
    // Fibonaxi duyệt mảng
    long FibonaxiOther (int n) {
        long [] fibo = new long [100];
        fibo[0] = 0;
        fibo[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            long value = fibo[i-1] + fibo[i-2];
            fibo[i] = value;
        }
        
        return fibo[n];
    }
    
    public static void main(String[] args) {
        FirstPractice  p1 = new FirstPractice();
        System.out.println(p1.FibonaxiOther(80));
        System.out.println(p1.GCD(0,5));
    }
    
}
