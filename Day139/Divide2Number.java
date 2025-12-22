package Day139;

import java.util.Scanner;

public class Divide2Number {
    static int divide2Number(int dividend,int divisor){
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = true;
        if(dividend>=0 && divisor<0) sign = false;
        if(dividend<=0 && divisor>0) sign = false;
        long n = Math.abs((long)dividend);
        long d= Math.abs((long)divisor);
        long ans = 0;
        while(n>=d){
            int cnt = 0;
            while(n>=(d<<cnt+1)) cnt++;
            ans+=(1<<cnt);
            n = n-(d<<cnt);
        }
        
        return sign?(int)ans:-(int)ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Dividend");
        int n = sc.nextInt();
        System.out.println("Enter Divisor");
        int d = sc.nextInt();
        System.out.println(divide2Number(n, d));
        sc.close();
    }
    
}
