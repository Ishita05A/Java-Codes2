package Day111;

import java.util.ArrayList;
import java.util.Scanner;

public class MajorityN_by3 {
    static ArrayList<Integer> majority(int[] arr){
        int n = arr.length;
        ArrayList<Integer> a = new ArrayList<>();
        int c1 = 0,c2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            if(c1 == 0 && ele2 != arr[i]) ele1 = arr[i];
            else if(c2 == 0 && arr[i] != ele1) ele2 = arr[i];
            else if(ele1 == arr[i]) c1++;
            else if(ele2 == arr[i]) c2++;
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;c2 = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == ele1) c1++;
            if(arr[i] == ele2) c2++;
        }
        int mini = (int)n/3 +1;
        if(c1 > mini) a.add(ele1);
        if(c2 > mini) a.add(ele2);
        return a;
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
        ArrayList<Integer> a= majority(arr);
        System.out.println(a);
        sc.close();
    }
    
}
