package Day139;

import java.util.Scanner;

public class ithBitSetOrNot {
    static boolean is_ith_bit_set(int n,int i){
        if((n & (1<<i)) != 0) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println("Enter ith position");
        int i = sc.nextInt();
        System.out.println(is_ith_bit_set(n,i ));
        sc.close();
    }
    
}
