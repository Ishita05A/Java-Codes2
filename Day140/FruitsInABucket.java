package Day140;
import java.util.*;
import java.util.Scanner;

public class FruitsInABucket {
    static int fruitsIntoBasket(int[] arr){
        int maxLen = 0;
        for(int i = 0;i<arr.length;i++){
            HashSet<Integer> mp = new HashSet<>();
            for(int j = i;j<arr.length;j++){
                mp.add(arr[j]);
                if(mp.size()>2) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    static int fruitsIntoBasket_optimized(int[] arr){
        int maxLen = 0;
        int l = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int r = 0;r<arr.length;r++){
            mp.put(arr[r],mp.getOrDefault(arr[r], 0)+1);
            if(mp.size()>2){
                while(mp.size()>2){
                    mp.put(arr[l], mp.get(arr[l])-1);
                    if(mp.get(arr[l])==0) mp.remove(arr[l]);
                    l++;
                }
                
            }
            if(mp.size()<=2){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
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
        System.out.println(fruitsIntoBasket(arr));
        System.out.println(fruitsIntoBasket_optimized(arr));
        sc.close();
    }
    
}
