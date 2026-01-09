package Day152;

import java.util.Scanner;

public class JumpGame {
    static boolean canJump(int[] arr){
        int maxIndex = 0;
        for(int i = 0;i<arr.length;i++){
            if(i>maxIndex) return false;
            maxIndex = Math.max(maxIndex, i+arr[i]);
        }
        return true;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(canJump(arr));
        sc.close();
    }
    
}
