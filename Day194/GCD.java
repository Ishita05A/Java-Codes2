package Day194;

public class GCD {
    static int gcd_rec(int a, int b){
        if(a == 0) return b;
        return gcd_rec(b%a, a);
    }
    static int gcd(int n1,int n2){
        while(n2 != 0){
            int temp = n2;
            n2 = n1%n2;
            n1 = temp;
        }
        return n1;
    }
    public static void main(String[] args) {
        System.out.println(gcd(20, 15));
        System.out.println(gcd_rec(20, 15));
    }
    
}
