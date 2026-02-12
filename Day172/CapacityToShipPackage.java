// package Day172;
import java.util.*;
public class CapacityToShipPackage {
    static int findMax(int[] arr){
        int max = 0;
        for(int num:arr) max = Math.max(max,num);
        return max;
    }
    static int findSum(int[] arr){
        int sum = 0;
        for(int num:arr) sum+=num;
        return sum;
    }
    static int daysTaken(int[] arr,int maxWt){
    
        int weight = 0;
        int days = 1;
        for(int i = 0;i<arr.length;i++){
            if(weight+arr[i]>maxWt){
                days++;
                
                weight = 0;
            }
            weight += arr[i];
        }
        
        return days;
    }
    static int findMinWeight(int[] arr,int d){
        int st = findMax(arr);
        int end = findSum(arr);
        int ans = end;
        while(st<=end){
            int mid = (st+end)/2;
            int daysTaken = daysTaken(arr, mid);
            if(daysTaken<=d){
                ans = mid;
                end = mid -1;
            }
            else st = mid+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findMinWeight(arr, 3));
        sc.close();
    }
    
}
