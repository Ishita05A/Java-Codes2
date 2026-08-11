import java.util.Scanner;

public class BOddGrasshopper {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            long x = sc.nextLong();
            long n = sc.nextLong();
            if(n%4 == 0){
                System.out.println(x);
                continue;
            }
            long b = n - (n%4) +1;
            while (b<=n) {
                if(x%2 == 0) x-=b;
                else x+=b;
                b++;
            }
            System.out.println(x);
        }
    }
}