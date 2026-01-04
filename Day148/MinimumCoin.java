package Day148;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumCoin {
    static ArrayList<Integer> findMin(int[] deno ,int v){
        int n = deno.length;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--){
            while(v>=deno[i]){
                v-=deno[i];
                ans.add(deno[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements for greed");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMin(arr, 49));
        sc.close();

    }
    
}
