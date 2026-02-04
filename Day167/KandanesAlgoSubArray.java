package Day167;
import java.util.*;
public class KandanesAlgoSubArray{
    static List<Integer> subArray(int[] arr){
        int st = 0;
        int end = 0;
        int sum = 0;
        int beg = 0;
        int max = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum > max){
                max = sum;
                end = i;
                st = beg;
            }
            if(sum < 0){
                sum = 0;
                beg = 0;
            }
        }
        for(int i = st;i<=end;i++){
            ans.add(arr[i]);
        }
        return ans;
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
        System.out.println(subArray(arr));
        sc.close();
    }

}