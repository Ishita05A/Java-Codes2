import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {
    static int findMajority(int[] arr){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int max = 0;
        int ans = 0;
        for(int i = 0;i<arr.length;i++){
            if(!mp.containsKey(arr[i])) mp.put(arr[i], 1);
            else mp.put(arr[i], mp.get(arr[i])+1);
        }
        for(var num : mp.entrySet()){
            if(num.getValue()>max){
                max = num.getValue();
                ans = num.getKey();
            }
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
        System.out.println(findMajority(arr));
        sc.close();
    }
    
}
