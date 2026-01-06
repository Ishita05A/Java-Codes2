package Day150;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequenceInArray {
    static int largest_consequative_sequence_optimized(int[] arr){
        int longest = 0;
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            mp.add(arr[i]);
        }
        for(int i = 0;i<arr.length;i++){
            if(!mp.contains(arr[i]-1)){
                int cnt = 0;
                int x = arr[i];
                while(mp.contains(x)){
                    cnt++;
                    x = x+1;
                }
                longest = Math.max(cnt, longest);
            }
        }
        return longest;
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

        System.out.println(largest_consequative_sequence_optimized(arr));
        sc.close();
    }
    
}
