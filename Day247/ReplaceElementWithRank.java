package Day247;

import java.util.Arrays;
import java.util.HashMap;

public class ReplaceElementWithRank {
    static int[] rank(int[] arr){
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer> mp = new HashMap<>();
        int rank = 1;
        for(int i = 0;i<arr.length;i++){
            if(!mp.containsKey(sorted[i])){
                mp.put(sorted[i],rank);
                rank++;
            }
        }
        for(int i  = 0;i<arr.length;i++){
            arr[i] = mp.get(arr[i]);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {1, 5, 8, 15, 8, 25, 9};

        int[] res = rank(arr);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }
    
}
