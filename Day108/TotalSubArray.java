package Day108;
import java.util.HashSet;
import java.util.Scanner;

public class TotalSubArray {
    static int total_SumArray(int[] arr,int k){
        int sum = 0;
        int count = 0;
        HashSet<Integer> mp = new HashSet<>();
        mp.add(0);
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k) count ++;
            if(mp.contains(k-sum)) count++;
            mp.add(sum);
            
        }
        return count;
        
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
        System.out.println(total_SumArray(arr, 3));
        sc.close();
    }
    
}
