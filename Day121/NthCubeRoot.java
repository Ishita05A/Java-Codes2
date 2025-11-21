package Day121;

import java.util.Scanner;

public class NthCubeRoot {
    static int findNthRoot(int n,int k){
        int st = 0;
        int end = k;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(Math.pow(mid, n) ==k) return mid;
            else if(Math.pow(mid, n)< k) st = mid +1;
            else end = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target");
        int target = sc.nextInt();
        System.out.println("Enter nth  value");
        int n = sc.nextInt();
        System.out.println(findNthRoot(n, target));
        sc.close();
    }
    
}
