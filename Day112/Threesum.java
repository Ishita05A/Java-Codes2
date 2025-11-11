package Day112;

import java.util.*;

public class Threesum {
    static List<List<Integer>> find3sum(int[] arr){
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            HashSet<Integer> mp = new HashSet<>();
            for(int j = i+1;j<arr.length;j++){
                
                int third= -(arr[i]+arr[j]);
                if(mp.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i],arr[j],third);
                    temp.sort(null);
                    ans.add(temp);
                }
                mp.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);

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
        List<List<Integer>> ans = find3sum(arr);
        System.out.println(ans);
        sc.close();
        
    }
}
