package Day151;

import java.util.Scanner;
import java.util.*;

public class ThreeSumProblem {
    // Also adds duplicate.....
    static List<List<Integer>> tripletSum_brute(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                    if(arr[i]+arr[j]+arr[k] == 0){
                        List<Integer> a = new ArrayList<>();
                        a.add(arr[i]);
                        a.add(arr[j]);
                        a.add(arr[k]);
                        ans.add(a);
                    }
                }
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
        System.out.println(tripletSum_brute(arr));
        sc.close();
    }
    
}
