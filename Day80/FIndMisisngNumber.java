package Day80;


import java.util.HashSet;
import java.util.Scanner;

public class FIndMisisngNumber {
    
    // static int findMissing(int[] arr){
    //     int max = Integer.MIN_VALUE;
    //     int ans = 0;
    //     HashMap<Integer,Integer> mp = new HashMap<>();
    //     for(int i = 0;i<arr.length;i++){
    //         if(arr[i]>max) max = arr[i];
    //     }
    //     for(int i = 0;i<=max;i++){
    //         mp.put(i, 0);
    //     }
    //     for(int i = 0; i<arr.length;i++){
    //         if(mp.containsKey(arr[i])) mp.put(arr[i], 1);
    //     }
    //     for(int i = 0;i<mp.size();i++){
    //         if(mp.get(i)==0) ans = i;
    //     }
    //     return ans;
    // }

    static int findMissing(int[] arr){
        HashSet<Integer> mp = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        for( int num : arr){
            mp.add(num);
            if(num > max) max = num;
            if(num < min) min = num;
        }
        for(int i = min; i<=max; i++){
            if(!mp.contains(i)) ans = i;
        }
        return ans;
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
        System.out.println(findMissing(arr));
        sc.close();
    }
    
}
