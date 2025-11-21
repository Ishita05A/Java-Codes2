package Day121;

import java.util.Scanner;

public class FindSquareRoot {
    static int findSQRT(int target){
        int st = 0;
        int end = target;
        int ans = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(mid * mid <= target) {
                ans = mid;
                st = mid + 1;
            }
            else end = mid-1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target");
        int target = sc.nextInt();
        
        System.out.println(findSQRT( target));
        sc.close();
    }
    
}
