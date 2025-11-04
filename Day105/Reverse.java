package Day105;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        
        int n = sc.nextInt();
        int num = 0;
        while(n != 0){
            num = num*10 + n%10;
            n/=10;
        }
        System.out.println(num);
        sc.close();
    }
}
