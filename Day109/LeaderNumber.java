package Day109;
import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class LeaderNumber {
     static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static ArrayList<Integer> findLeaderNumber(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int max = arr[arr.length-1];
        ans.add(arr[arr.length-1]);
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i]> max){
                ans.add(arr[i]);
                max = arr[i];
            }
            
        }
        Collections.reverse(ans);
        return  ans;
        
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
        ArrayList<Integer> ans = findLeaderNumber(arr);
        System.out.println(ans);
        sc.close();

    }
    
}
