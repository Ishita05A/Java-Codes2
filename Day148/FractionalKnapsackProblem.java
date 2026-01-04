package Day148;

import java.util.PriorityQueue;
import java.util.Scanner;

public class FractionalKnapsackProblem {
    static class Triplet{
        double perKg;
        int value;
        int weight;
        Triplet(double perKg,int val,int wt){
            this.perKg = perKg;
            this.value = val;
            this.weight = wt;
        }
    }
    static double findMaxValue(int[] val,int[] wt,int capacity){
        PriorityQueue<Triplet> pq = new PriorityQueue<>((a,b)->Double.compare(b.perKg,a.perKg));
        for(int i = 0;i<wt.length;i++){
            pq.add(new Triplet((double)val[i]/wt[i], val[i], wt[i]));
        }
        double max = 0;
        int w = 0;
        while(!pq.isEmpty()){
            Triplet top = pq.peek();
            if(w+top.weight <= capacity){
                max+=top.value;
                w+=top.weight;
                pq.poll();
            }
            else break;   
        }
        int rem = capacity-w;
            if(rem>0 && !pq.isEmpty()){
                Triplet top = pq.peek();
                max+=(rem*top.perKg);
                
            }
            return max;
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
        System.out.println(findMaxValue(arr, s, 50));
        sc.close();
    }
    
}
