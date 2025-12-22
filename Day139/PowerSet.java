package Day139;
import java.util.*;
import java.util.Scanner;

public class PowerSet {
    static List<List<Integer>> powerSet(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        for(int num = 0;num<(1<<n);num++){
            List<Integer> a = new ArrayList<>();
            for(int i = 0;i<n;i++){
                if((num & (1<<i) )!=0) a.add(arr[i]);
            }
            ans.add(a);
        }
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
        System.out.println(powerSet(arr));
        sc.close();
    }
    
}
