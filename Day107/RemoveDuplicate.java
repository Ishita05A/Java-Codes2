package Day107;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicate {
    static int remove_duplicate(int[] arr){
        
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) {
                
                mp.put(arr[i], 1);
            }
        }
        int k = 0;
        for(var e:mp.entrySet()){
            arr[k++] = e.getKey();
        }
        return mp.size();
        
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
        System.out.println(remove_duplicate(arr));
        sc.close();
    }
    
}
