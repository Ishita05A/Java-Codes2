package Day123;

import java.util.Scanner;

public class FindSquareroot {
    static int square_root(int n){
        int st = 0;
        int end = n;
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(mid*mid <= n) {
                ans = mid;
                st = mid +1;
            }
            else end = mid -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(square_root(n));
        sc.close();
        
    }
    
}
