package Day139;

import java.util.Scanner;

public class CountNoOfSetBit {
    static int count_no_of_set(int n){
        int count = 0;
        while(n>0){
            n = n &(n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(count_no_of_set(n));
        sc.close();
    }
    
}
