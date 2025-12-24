package Day141;
import java.util.*;
import java.util.Scanner;

public class FindAllDuplicatesInArray {
    static List<Integer> findDuplicates(int[] arr){
        HashSet<Integer> mp = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(mp.contains(arr[i])) ans.add(arr[i]);
            mp.add(arr[i]);
        }
        return ans;
    }
    static int findDuplicates_only1(int[] arr){
        int slow = arr[0];
        int fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]]; 
        }
        while(slow != fast);
        fast = arr[0];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        // System.out.println(findDuplicates(arr));
        System.out.println(findDuplicates_only1(arr));
        sc.close();

    }
    
}
