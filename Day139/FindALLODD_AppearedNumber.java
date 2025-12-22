package Day139;
import java.util.*;
import java.util.Scanner;

public class FindALLODD_AppearedNumber {
    static List<Integer> findAllOddAppeared(int[] arr){
        List<Integer> ans = new ArrayList<>();
        long xor = 0;
        for(int num : arr){
            xor^=num;
        } 
        int b1 = 0;
        int b2 = 0;
        long rightMost = (xor & (xor-1)) & xor;
        for(int num : arr){
            if((rightMost&num )!= 0) b1^=num;
            else b2^=num;
        }
        ans.add(b1);
        ans.add(b2);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findAllOddAppeared(arr));
        sc.close();
    }
    
}
