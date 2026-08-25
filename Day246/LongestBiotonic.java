package Day246;

import java.util.Arrays;

public class LongestBiotonic {
    static int longest(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];
        int[] lds = new int[n];
        Arrays.fill(lis, 1);
        Arrays.fill(lds, 1);
        for(int i = 0;i<n;i++){
            for(int prev = 0;prev<i;prev++){
                if(arr[prev] < arr[i]){
                    lis[i] = Math.max(lis[i], lis[prev]+1);
                } 
            }
        }

        for(int i = n-1;i>=0;i--){
            for(int prev = n-1;prev>i;prev--){
                if(arr[prev] < arr[i]){
                    lds[i] = Math.max(lds[i], lds[prev]+1);
                }
            }
        }
        int max = 0;
        for(int i = 0;i<n;i++){
            max = Math.max(max,lds[i]+lds[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 3, 6, 8, 7};
        System.out.println(longest(arr));
    }
    
}
