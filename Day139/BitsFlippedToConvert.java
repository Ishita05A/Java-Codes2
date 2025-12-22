package Day139;

import java.util.Scanner;

public class BitsFlippedToConvert {
    static int countFlippedBit(int start ,int goal){
        int ans = start^goal;
        int count = 0;
        while(ans>0){
            ans = ans & (ans-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Start");
        int n = sc.nextInt();
        System.out.println("Enter Goal");
        int d = sc.nextInt();
        System.out.println(countFlippedBit(n, d));
        sc.close();
    }
    
}
