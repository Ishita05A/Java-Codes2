package Day139;

import java.util.Scanner;

public class CheckIsN_powerOf2 {
    static boolean is_of_pow2(int n){
        if(n>0 && (n & n-1) == 0) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(is_of_pow2(n));
        sc.close();
    }
    
}
