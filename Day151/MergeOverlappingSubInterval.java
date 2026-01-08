package Day151;
import java.util.*;

public class MergeOverlappingSubInterval {
    static List<List<Integer>> merge(int[][] arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        while(i<n){
            int st = arr[i][0];
            int end = arr[i][1];
            int j = i+1;
            while(j<n && arr[j][0]<end){
                end = Math.max(end, arr[j][1]);
                j++;
            }
           ans.add(Arrays.asList(st,end));
           i=j;
        }
        return ans;

    }
    static List<List<Integer>> merge_optimized(int[][] arr){
        List<List<Integer>> ans = new ArrayList<>();
        for(int[] interval : arr){
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1)<interval[0]){
                ans.add(Arrays.asList(interval[0],interval[1]));
            }
            else{
                int last = ans.size()-1;
                int maxEnd = Math.max(ans.get(last).get(1), interval[1]);
                ans.get(last).set(1, maxEnd);
            }
            
        }
        return ans;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        System.out.println("Enter columns");

        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(merge(arr));
        System.out.println(merge_optimized(arr));
        sc.close();
    }
    
}
