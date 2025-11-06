package Day107;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FindUnion {
     static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] find_union1(int[] arr1,int[] arr2){
        HashSet<Integer> mp = new HashSet<>();
        for(int num : arr1) mp.add(num);
        for(int num : arr2) mp.add(num);
        int[] ans = new int[mp.size()];
        int i = 0;
        for(int e: mp) ans[i] = e;
        return ans;
    }
    static int[] find_union(int[] arr1,int[] arr2){
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            if(!mp.containsKey(arr1[i])) mp.put(arr1[i], 1);
        }

        for(int i = 0;i<arr2.length;i++){
            if(!mp.containsKey(arr2[i])) mp.put(arr2[i], 1);
        }
        int[] ans = new int[mp.size()];
        int k = 0;
        for(var e:mp.entrySet()) ans[k++] = e.getKey();
        return ans;
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
        System.out.println("Enter no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }
        int[] ans = find_union(arr, arr1);
        display(ans);
        sc.close();
    }
    
}
