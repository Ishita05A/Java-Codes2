package Day167;
import java.util.Scanner;
import java.util.*;
public class ConsequetiveNumbers {
    static int maxConsecutive(int[] arr){
        int max = 0;
        int count = 0;
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            mp.add(arr[i]);
        }
        for(int i = 0;i<arr.length;i++){
            if(!mp.contains(arr[i]-1) && mp.contains(arr[i])){
                count = 1;
                int ele = arr[i];
                while(mp.contains(ele+count)){
                    count++;
                    max = Math.max(max, count);

                }
            }
        }
        return max;
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
        System.out.println(maxConsecutive(arr));
        sc.close();
    }
    
}
