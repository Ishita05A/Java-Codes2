package Day159;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Fractionalknapsack {
    static class Triplet{
        Double perkg;
        int values;
        int weight;
        Triplet(Double perkg,int values,int weight){
            this.perkg = perkg;
            this.values = values;
            this.weight = weight;
        }
    }
    static double maximizedValue(int[] val, int[] wt,int capacity){
        PriorityQueue<Triplet> q = new PriorityQueue<>((a,b)->Double.compare(b.perkg, a.perkg));
        for(int i = 0;i<val.length;i++){
            q.add(new Triplet((double)val[i]/wt[i], val[i], wt[i]));
        }
        double maxCap = 0;
        double ans = 0;
        while(!q.isEmpty()){
            int values = q.peek().values;
            int weight = q.peek().weight;
            q.poll();
            if(maxCap+ weight < capacity ){
                maxCap+=weight;
                ans+=values;
            }
            else break;
        }
        double rem = capacity-maxCap;
        if(rem>0 && !q.isEmpty()){
            ans += rem*q.peek().perkg;
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
        System.out.println("Enter elements for weight");
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        System.out.println(maximizedValue(arr, s, 50));
        sc.close();
    }
    
}
