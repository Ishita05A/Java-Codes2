package Day118;


import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] find_2_sum(int[] arr,int target){
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(mp.contains(target-arr[i])) return new int[] {target-arr[i],arr[i]};
            mp.add(arr[i]);
        }
        return new int[] {-1,-1};
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
        int[] ans = find_2_sum(arr, 4);
        display(ans);
        sc.close();
    }
    
}
