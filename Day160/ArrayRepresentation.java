package Day160;

import java.util.Scanner;
import java.util.*;
public class ArrayRepresentation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i = 0;i<=n;i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<arr[i].size();j++){
                System.out.print(arr[i].get(j)+" ");
            }
            System.out.println();
        }
        sc.close();

    }
    
}
