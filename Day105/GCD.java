package Day105;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println("Enter 2nd number");
        int n1 = sc.nextInt();
        int i = Math.min(n, n1);
        while (i != 0) {
            if(n% i ==0 && n1 %i == 0){
                System.out.println(i);
                break;
            }
            i--;
        }
        sc.close();

    }
    
}
