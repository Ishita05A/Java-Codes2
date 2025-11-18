package Day117;

import java.util.Scanner;
import java.util.*;

public class FindUnion {
    static ArrayList<Integer> findUnion(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i<arr1.length && j<arr2.length ){
            if(arr1[i] <= arr2[j]  ){
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]) ans.add(arr1[i]);
                i++;
            }
            else{
                if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j]) ans.add(arr2[j]);
                j++;
            }
        }
        while(i<arr1.length){
            if(ans.size() == 0 || ans.get(ans.size()-1) != arr1[i]) ans.add(arr1[i]);
            i++;
        }
        while(j<arr2.length){
            if(ans.size() == 0 || ans.get(ans.size()-1) != arr2[j]) ans.add(arr2[j]);
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.println("Enter no. of element of arr 2");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = findUnion(arr1, arr2);
        System.out.println(ans);
        sc.close();

    }
    
}
