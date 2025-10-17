package Day96;
import java.util.*;
public class KadaneAlgorithm {


    // Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
    // Output: 6 
    static int maximum_sum(int[] arr){
        int n = arr.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            sum+=arr[i];
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        return max;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elments");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Elements");
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maximum_sum(arr));
        sc.close();

    }
    
}
