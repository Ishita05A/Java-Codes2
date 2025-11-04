package Day105;

import java.util.Scanner;

public class CheckPallindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        
        int n = sc.nextInt();
        int num = n;
        int rev = 0;
        while(n != 0){
            rev= rev*10 + n%10;
            n/=10;
        }
        if(num == rev) System.out.println("True");
        else System.out.println("False");
        
        sc.close();
    }
    
}
