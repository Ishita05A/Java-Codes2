package Day167;
import java.util.*;
import java.util.Scanner;

public class LeadersInArray {
    static List<Integer> leaders(int[] arr){
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        ans.add(arr[n-1]);
        for(int i = arr.length-2;i>=0;i--){
            if(arr[i] > arr[i+1] && arr[i] > ans.get(ans.size()-1)) ans.add(arr[i]);
        }
        Collections.reverse(ans);
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(leaders(arr));
        sc.close();
    }
    
}
