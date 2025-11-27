package Day125;

import java.util.PriorityQueue;
import java.util.Scanner;
class Pair {
    double distance;
    int index;
    Pair(double distance,int index){
        this.distance = distance;
        this.index = index;
    }
}

public class GasStation2 {
    
    static double findMinimum_distance(int[] arr,int k){
        int n = arr.length;
        int[] howMany = new int[n-1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->Double.compare(b.distance, a.distance));
        for(int i = 0;i<n-1;i++){
            pq.add(new Pair(arr[i+1]-arr[i],i ));
        }
        for(int gasStation = 1;gasStation<=k;gasStation++){
            Pair top = pq.poll();
            int idx = top.index;
            howMany[idx]++;

            double totalDist = arr[idx+1]-arr[idx];
            double newDist = totalDist/(howMany[idx]+1);
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
        sc.close();
    }
    
}
