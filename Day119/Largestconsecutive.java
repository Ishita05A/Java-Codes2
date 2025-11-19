package Day119;

import java.util.Arrays;
import java.util.Scanner;

public class Largestconsecutive {
    static int find_longest_consecutive(int[] arr){
        int n = arr.length;
        int c = 1;
        int max = 0;
        Arrays.sort(arr);
        for(int i = 0;i<n-1;i++){
            if(arr[i]+1 == arr[i+1]){
                c++;
                max = Math.max(max, c);
            }
            else if(arr[i] == arr[i+1]) continue;
            else c= 1;
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
        System.out.println(find_longest_consecutive(arr));
        sc.close();
    }
    
}
