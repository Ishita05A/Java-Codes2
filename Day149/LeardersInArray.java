package Day149;

import java.util.ArrayList;
import java.util.Scanner;

public class LeardersInArray {
    static ArrayList<Integer> findLeader_brute(int[] arr){
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            boolean flag = true;
            for(int j = i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true) ans.add(arr[i]);
        }
        return ans;
    }
    static ArrayList<Integer> findLeader_optimized(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
        
        return ans;


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
        System.out.println(findLeader_brute(arr));
        System.out.println(findLeader_optimized(arr));
        sc.close();
    }
    
}
