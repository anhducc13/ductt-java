package week4;

public class Program {
    public static int max(int a, int b) {
        return a>b?a:b;
    }
    
    public static int min (int [] arr) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public static String BMI(double weight, double height) {
        double getBMI = Math.round(weight/(height*height)*100)/100;
        
        if(getBMI < 18.50) return "Thiếu cân";
        else if(getBMI < 22.99) return "Bình thường";
        else if(getBMI < 24.99) return "Thừa cân";
        else return "Béo phì";
    }
    
}
