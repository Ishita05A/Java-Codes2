package Day200.Recursion;

public class Power {
    static double power(double x,int n){
        
        if(n == 1) return x;
        return x*power(x, n-1);
    }
    public static void main(String[] args) {
        System.out.println(power(2, 5));
    }
    
}
