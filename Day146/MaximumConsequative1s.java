package Day146;

import java.util.Scanner;

public class MaximumConsequative1s {
    static int maxConsq_1_brute(int[] arr,int k){
        int maxLen = 0;
        for(int i = 0;i<arr.length;i++){
            int c = 0;
            for(int j = i;j<arr.length;j++){
                if(arr[j] == 0) c++;
                if(c>k) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    static int maxConsecutive_optimized(int[] arr,int k){
        int maxLen = 0;
        int l = 0;
        int zeros = 0;
        for(int r = 0;r<arr.length;r++){
            if(arr[r] == 0) zeros+=1;
            while(zeros>k){
                if(arr[l] == 0){
                    zeros--;
                }
                l++;
            }
            if(zeros<=k) maxLen = Math.max(maxLen,r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxConsq_1_brute(arr, 3));
        System.out.println(maxConsecutive_optimized(arr, 3));
        sc.close();
    }
    
}
