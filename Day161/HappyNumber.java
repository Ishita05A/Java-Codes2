package Day161;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {
    static boolean isHappy(int n){
        HashSet<Integer> mp = new HashSet<>();
        while(n != 1){

            if(mp.contains(n)){
                return false;
            }
            mp.add(n);
            n = sumOfSquare(n);   
        }
        return true;
    }
    static int sumOfSquare(int n){
        int sum = 0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(isHappy(n));
        sc.close();
    }
    
}
