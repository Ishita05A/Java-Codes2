package Day107;

import java.util.Scanner;

public class MaximumConsecutive {
    static int find_consecutive(int[] arr){
        int i = 0;
        int n = arr.length;
        int c = 1;
        int max = 0;
        while(i<n-1){
            if(arr[i] == arr[i+1]){
                c++;
                max = Math.max(max, c);
            } 
            
            else{
                
                c = 1;
            }
            i++;
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
        System.out.println(find_consecutive(arr));
        sc.close();
    }
    
}
