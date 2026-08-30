package Day249;

public class GcdOfNumber {
    static int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
    public static void main(String[] args) {
        System.out.println(gcd(9, 12));
    }
}
