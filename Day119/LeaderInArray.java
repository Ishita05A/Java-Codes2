package Day119;

import java.util.Scanner;
import java.util.*;

public class LeaderInArray {
    static ArrayList<Integer> findLeader(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = arr[n-1];
        ans.add(arr[n-1]);
        for(int i = n-2;i>=0;i--){
            if(arr[i]>max){
                ans.add(arr[i]);
                max = arr[i];
            }
        }
         Collections.reverse(ans);
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
        ArrayList<Integer> ans = findLeader(arr);
        System.out.println(ans);
        sc.close();
    }
    
}
