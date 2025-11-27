package Day126;

import java.util.Scanner;

public class GasStation {
    static double minimize_max_distance(int[] arr,int k){
        int n = arr.length;
        int[] howmany = new int[n-1];
        for(int gasStation = 1;gasStation<=k;gasStation++){
            double maxSection = -1;
            int maxIdx = -1;
            for(int i = 0;i<n-1;i++){
                int diff = arr[i+1]-arr[i];
                double section_length = diff/(double)(howmany[i]+1);
                if(section_length>maxSection){
                    maxSection = section_length;
                    maxIdx = i;
                }
            }
            howmany[maxIdx]++;
        }
        double maxAns = -1;
        for(int i = 0;i<n-1;i++){
            double diff = arr[i+1]-arr[i];
            double section_length = diff/(double)(howmany[i]+1);
            maxAns = Math.max(maxAns, section_length);
        }
        return maxAns;
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
        System.out.println("Enter no of splits");
        int k = sc.nextInt();
        System.out.println(minimize_max_distance(arr, k));
        sc.close();
    }
    
}
