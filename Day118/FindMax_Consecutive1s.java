package Day118;

import java.util.Scanner;

public class FindMax_Consecutive1s {
    static int find_max_consecutive(int[] arr){
        int n = arr.length;
        int c = 0;
        int max = 0;
        for(int i = 0;i<n;i++){
            if(arr[i] == 1){
                c++;
                max = Math.max(max, c);
            }
            else c = 0;
        }
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
        System.out.println(find_max_consecutive(arr));
        sc.close();
    }
}
