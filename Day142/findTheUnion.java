package Day142;
import java.util.*;
import java.util.Scanner;

public class findTheUnion {
    static List<Integer> findUnion(int[] arr1,int[] arr2){
        List<Integer> ans = new ArrayList<>();
        int n = arr1.length;
        int m = arr2.length;
        int i = 0,j=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                ans.add(arr1[i]);
                i++;
            }
            else if(arr1[i] == arr2[j]){
                ans.add(arr2[j]);
                i++;
                j++;
            }
            else{
                ans.add(arr2[j]);
                j++;
            }
        }
        while(i<n){
            if(ans.get(ans.size()-1) != arr1[i]){
                ans.add(arr1[i]);
                i++;
            }
        }
        while(j<m){
            if(ans.get(ans.size()-1) != arr2[j]){
                ans.add(arr2[j]);
                j++;
            }
        }
        return ans;
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
         System.out.println("Enter no. of elements");
        int m = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr1 = new int[m];
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println(findUnion(arr1, arr));
        sc.close();
    }
    
}
