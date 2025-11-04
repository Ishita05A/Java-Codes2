package Day105;

import java.util.Scanner;

public class FibonacciSeries {
    static int fibo(int n){
        if(n == 0 || n == 1) return n;
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        for(int i = 0;i<=n;i++){
            System.out.print(fibo(i)+" ");
        }
        sc.close();
    }
    
}
