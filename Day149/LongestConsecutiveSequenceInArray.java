package Day149;
import java.util.*;
import java.util.Scanner;

public class LongestConsecutiveSequenceInArray {
    static int largest_consequative_sequence(int[] arr){
        Arrays.sort(arr);
        int cntCurr = 0,lastSmall = Integer.MIN_VALUE,longest = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i]-1!=lastSmall){
                cntCurr = 1;
                lastSmall = arr[i];
            }else{
                cntCurr++;
                lastSmall = arr[i];
            }
            longest = Math.max(longest, cntCurr);
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
        System.out.println(largest_consequative_sequence(arr));
        sc.close();
    }
    
}
