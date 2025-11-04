package Day105;

import java.util.Scanner;

public class Nto1 {
    static void n_to_1(int n){
        if(n == 0) return;
        System.out.print(n+" ");
        n_to_1(n-1);
    }
    static void one_to_n(int n){
        if(n == 0) return;
        
        n_to_1(n-1);
        System.out.print(n+" ");

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        one_to_n(n);
        System.out.println();
        n_to_1(n);
        sc.close();
    }
    
}
