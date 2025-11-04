package Day105;

import java.util.Scanner;

public class ArmStrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        int num = n;
        int num1 = n;
        int count = 0;
        int ans = 0;
        int rem = 0;
        while(num1 != 0){
            count++;
            num1/=10;
        }
        while(num != 0){
            rem = num%10;
            ans += Math.pow(rem, count);
            num/=10; 
        }
        if(ans == n) System.out.println("yes");
        else System.out.println("No");
        
        sc.close();

    }
    
}
