package Day228;

import java.util.Arrays;

public class JobSequencing {
    static int[] maxProfit(int[][] arr){
        int n = arr.length;
        Arrays.sort(arr,(a,b)->b[2]-a[2]);
        int day = 0;
        for(int i = 0;i<n;i++){
            day = Math.max(day, arr[i][1]);
        }
        int[] job = new int[day+1];
        Arrays.fill(job,-1);
        int profit = 0;
        int cnt = 0;
        for(int i = 0;i<n;i++){
            int dead = arr[i][1];
            while(job[dead] != -1 && dead > 0){
                dead--;
            }
            if(dead >0){
                job[dead] = arr[i][0];
                profit+=arr[i][2];
                cnt++;
            }
        }
        return new int[] {cnt,profit};
        
    }
    public static void main(String[] args) {
        int[][] job =  {{1, 2, 100} , {2, 1, 19} , {3, 2, 27} , {4, 1, 25} , {5, 1, 15}};
        int[] ans = maxProfit(job);
        System.out.println(ans[0]+" "+ans[1]);

    }
    
}
