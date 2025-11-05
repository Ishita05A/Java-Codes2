package Day106;

import java.util.Scanner;

public class FindMaxElement {
    static int find_max(int[] arr,int idx){
        if(idx == 0) return arr[0];
        int max = Math.max(arr[idx], find_max(arr, idx-1));
        return max;
        
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
        System.out.println(find_max(arr, n-1));
        sc.close();
    }
    
}
