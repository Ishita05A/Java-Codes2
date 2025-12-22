package Day139;

import java.util.Scanner;

public class Divide2Number {
    static int divide2Number(int n,int d){
        if(n == d) return 1;
        boolean sign = true;
        if(n>0 && d<0) sign = false;
        if(n<0 && d>0) sign = false;
        n = (int)Math.abs(n);
        d = (int)Math.abs(d);
        int ans = 0;
        while(n>=d){
            int cnt = 0;
            while(n>=(d<<cnt+1)) cnt++;
            ans+=(1<<cnt);
            n = n-(d<<cnt);
        }
        if(ans == (1<<31) && sign == true) return Integer.MAX_VALUE;
        if(ans == (1<<31) && sign == false) return Integer.MIN_VALUE;
        return sign?ans:-ans;
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
