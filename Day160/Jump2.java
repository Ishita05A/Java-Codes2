package Day160;

import java.util.Scanner;

public class Jump2 {
    
    static int findMinimumJumps(int[] arr){
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for(int i = 0;i<arr.length-1;i++){
            farthest = Math.max(farthest, i+arr[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMinimumJumps(arr));
        sc.close();
    }
}
