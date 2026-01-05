package Day149;
import java.util.*;
import java.util.Scanner;

public class TwoSumProblem {
    static int[] findTwoSum(int[] arr,int target){
        int n = arr.length;
        int sum = 0;
        int[][] numWithIdx = new int[n][2];
        for(int i = 0;i<arr.length;i++){
            numWithIdx[i][0] = arr[i];
            numWithIdx[i][1] = i;
        }
        Arrays.sort(numWithIdx,(a,b)->Integer.compare(a[0],b[0]));
        int l = 0;
        int r = n-1;
        while(l<r){
            sum = numWithIdx[l][0]+numWithIdx[r][0];
            if(sum == target) return new int[] {numWithIdx[l][1],numWithIdx[r][1]};
            else if(sum<target) l++;
            else r--;
        }
        return new int[] {-1,-1};
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
        int[] ans = findTwoSum(arr, 8);
        System.out.printf("%d %d",ans[0],ans[1]);
        sc.close();
    }
}
