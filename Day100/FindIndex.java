package Day100;

import java.util.ArrayList;
import java.util.Scanner;

public class FindIndex {
    static ArrayList<Integer> findIndexes(int[] arr,int idx,int x){
        if(idx == arr.length-1) return new ArrayList<>();

        ArrayList<Integer> result = findIndexes(arr, idx+1, x);
        if(arr[idx] == x) result.add(0,idx);
        return result;
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
        ArrayList<Integer> ans = findIndexes(arr, 0, 2);
        System.out.println(ans);
        sc.close();
    }
    
}
