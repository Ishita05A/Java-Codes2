import java.util.Scanner;

public class CVasilijeInCacak {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            long n = sc.nextLong();
            long k = sc.nextLong();
            long x = sc.nextLong();
            long min = ((n-k)*((n-k)+1))/2;
            long max = (n*(n+1))/2;
            if (x>= min && x<=max){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}