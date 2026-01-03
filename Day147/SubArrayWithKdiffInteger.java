package Day147;

import java.util.HashMap;
import java.util.Scanner;

public class SubArrayWithKdiffInteger {
    static int subArrayWithKDiffInt_brute(int[] arr,int k){
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            HashMap<Integer,Integer> mp = new HashMap<>();
            for(int j = i;j<arr.length;j++){
                mp.put(arr[j],mp.getOrDefault(arr[j], 0)+1);
                if(mp.size()>k) break;
                if(mp.size() == k) count++;
            }
        }
        return count;
    }
    static int lessAndEqual(int[] arr,int k){
        int count = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int l = 0;
        for(int r = 0;r<arr.length;r++){
            mp.put(arr[r], mp.getOrDefault(arr[r], 0)+1);
            while(mp.size()>k){
                mp.put(arr[l], mp.getOrDefault(arr[l], 0)-1);
                if(mp.get(arr[l])==0) mp.remove(arr[l]);
                l++;
            }
            if(mp.size()<=k) count+=(r-l+1);
        }
        return count;

    }
    static int subArrayWithKDiffInt_optimized(int[] arr,int k){
        return lessAndEqual(arr, k)-lessAndEqual(arr, k-1);
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
        System.out.println(subArrayWithKDiffInt_brute(arr, 2));
        System.out.println(subArrayWithKDiffInt_optimized(arr, 2));
        sc.close();
    }
    
}
