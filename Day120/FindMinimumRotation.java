package Day120;

import java.util.Scanner;

public class FindMinimumRotation {
    static int find_no_of_rotation(int[] arr){
        int st = 0;
        int end = arr.length-1;
        int ans = Integer.MAX_VALUE;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid]>=arr[st]){
                if(arr[st] < ans){
                    ans = arr[st];
                    idx = st;
                }
                st = mid+1;
                
            }
            else{
                if(arr[mid]<ans){
                    ans= arr[mid];
                    idx = mid;
                }
                end = mid -1;
            }
        }
        return idx;
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
        System.out.println(find_no_of_rotation(arr));
        sc.close();
    }
    
}
