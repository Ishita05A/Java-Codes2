package Day105;

import java.util.Scanner;

public class countDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        
        int n = sc.nextInt();
        int count = 0;
        while(n != 0){
            count++;
            n/=10;
        }
        System.out.println(count);
        sc.close();

    }
    
}
