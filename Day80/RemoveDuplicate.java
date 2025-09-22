package Day80;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicate {
    static int countunique(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int k = 0;
        for(int i =0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) {
                mp.put(arr[i], 1);
                arr[k++] = arr[i];
            }   
        }
        return mp.size();
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
        System.out.println(countunique(arr));
        sc.close();
        
    }
    
}
