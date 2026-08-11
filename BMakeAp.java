import java.util.Scanner;

public class BMakeAp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long new_a = 2*b-c;
            long new_b = (a+c)/2;
            long new_c = (2*b-a);
            boolean ans = false;
            if(new_a/a > 0 && new_a % a == 0) ans = true;
            else if(new_b/b > 0 && new_b % b == 0 && (c-a)%2 == 0) ans = true;
            else if(new_c/c > 0 && new_c % c == 0) ans = true;
            if(ans) System.out.println("YES");
            else System.out.println("NO"); 
        }

    }
}