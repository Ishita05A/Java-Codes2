package Day105;

import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        int c = 0;
        for(int i = 1;i<Math.sqrt(n);i++){
            if(n % i == 0){
                c++;
                if(n/i != i) c++;
            }
        }
        if(c == 2) System.out.println("Yes");
        else System.out.println("No");
        sc.close();

    }
    
}
