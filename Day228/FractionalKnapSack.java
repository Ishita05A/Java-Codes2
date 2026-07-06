package Day228;

import java.util.PriorityQueue;

public class FractionalKnapSack {
    static class Triplet{
        double perKg;
        int val;
        int wt;
        Triplet(double perKg, int val, int wt){
            this.perKg = perKg;
            this.val = val;
            this.wt = wt;
        }
    }
    static double maxValue(int[] val, int[] wt, long cap){
        PriorityQueue<Triplet> q = new PriorityQueue<>((a,b)->Double.compare(b.perKg, a.perKg));
        int n = wt.length;
        for(int i = 0;i<n;i++){
            q.add(new Triplet((double)val[i]/wt[i], val[i], wt[i]));
        }
        double max = 0;
        while(!q.isEmpty()){
            Triplet top = q.peek();
            if(cap-top.wt >= 0){
                cap-=top.wt;
                max+=top.val;
                q.poll();
            }
            else{
                break;
            }
        }
        if(cap > 0){
            max +=(cap*q.peek().perKg);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] val = {60,100,120};
        int[] wt = {10,20,30}; 
        long capacity = 50;
        System.out.println(maxValue(val, wt, capacity));
    }
    
}
