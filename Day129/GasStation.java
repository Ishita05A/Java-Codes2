package Day129;

import java.util.PriorityQueue;
import java.util.Scanner;
class Pair{
    double distance;
    int index;
    Pair(double distance,int index){
        this.distance = distance;
        this.index = index;
    }
}

public class GasStation {
    static int numberOfGasStationsRequired(double dist, int[] arr){
        int cnt = 0;
        for(int i = 1;i<arr.length;i++){
            int gap = arr[i]-arr[i-1];
            cnt+=(int)Math.ceil(gap/dist)-1;
        }
        return cnt;
    }
    static double optimized(int[] arr,int k){
        int n = arr.length;
        double low = 0;
        double high = 0;
        for(int i = 0;i<n-1;i++){
            high = Math.max(high, (double)(arr[i+1]-arr[i]));
        }
        double diff = 1e-6;
        while(high - low >diff){
            double mid = (low+high)/(2.0);
            int cnt = numberOfGasStationsRequired(mid,arr);
            if(cnt>k) low = mid;
            else high =  mid;
        }
        return high;
    }
    static double findMinimum_distance(int[] arr,int k){
        int n = arr.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Double.compare(b.distance,a.distance)
        );
        int[] howMany = new int[n-1];
        for(int i = 0;i<arr.length-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i], i));
        }
        for(int gasStation = 1;gasStation<=k;gasStation++){
            Pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;
            double diff = arr[idx+1]-arr[idx];
            double newDist = diff/(howMany[idx]+1);
            pq.add(new Pair(newDist, idx));
        }
        return pq.peek().distance;
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
        System.out.println("Enter target");
        int target = sc.nextInt();
         System.out.println(findMinimum_distance(arr, target));
         System.out.println(optimized(arr, target));
        sc.close();
    }
    
}
