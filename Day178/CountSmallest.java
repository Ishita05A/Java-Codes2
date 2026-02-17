package Day178;

import java.util.*;
public class CountSmallest {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] countSmallest(int[] arr){

        int[] duplicate = arr;
        Arrays.sort(duplicate);
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = i;
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
        int[] ans = countSmallest(arr);
        display(ans);
        sc.close();
    }
}
