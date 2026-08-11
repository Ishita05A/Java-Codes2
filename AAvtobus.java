import java.util.Scanner;

public class AAvtobus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            if(n % 2 != 0 || n<=3) {
                System.out.println(-1);
                continue;
            }
            long min = (n+5)/6;
            long max = n/4;
            System.out.println(min +" "+ max);
            
        }
    }
}