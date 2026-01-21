

import java.util.Scanner;

public class JumpGame1 {
    static boolean isJumpPossible(int[] arr){
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(i>max) return false;
            max = Math.max(max, i+arr[i]);
        }
        return true;
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
        System.out.println(isJumpPossible(arr));
        sc.close();
    }
    
}
