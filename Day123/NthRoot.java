package Day123;

import java.util.Scanner;

public class NthRoot {
    static int findNthRoot(int n ,int m){
        int st = 1;
        int end = n;
        
        while(st<=end){
            int mid = (end-st)/2+st;
            if(Math.pow(mid, m)== n) return mid;
            else if(Math.pow(mid, m) > n) end = mid - 1;
            else st = mid +1; 
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println("Enter the power");
        int m = sc.nextInt();
        System.out.println(findNthRoot(n, m));
        sc.close();
    }
    
}
