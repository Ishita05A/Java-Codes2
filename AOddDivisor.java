import java.util.Scanner;

public class AOddDivisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- >0) {
            long n = sc.nextLong();
            if(n == 1 || (n > 0 && (n & (n - 1)) == 0)) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}