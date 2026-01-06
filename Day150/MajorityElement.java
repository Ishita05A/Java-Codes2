package Day150;
import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {
    static List<Integer> elementsMoreThanNBy3_optimized(int[] arr){
        int cnt1 = 0, cnt2 = 0, ele1 =0,ele2 = 0;
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(cnt1 == 0 && ele2 != arr[i]){
                ele1 = arr[i];
                cnt1=1;
            }
            else if(cnt2 == 0 && ele1 != arr[i]){
                ele2 = arr[i];
                cnt2 = 1;
            }
            else if(ele1 == arr[i]) cnt1++;
            else if(ele2 == arr[i]) cnt2++;
            else {
                cnt1--;cnt2--;
            }
        }
        cnt1 = 0;
        cnt2=0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == ele1) cnt1++;
            if(arr[i] == ele2) cnt2++;
        }
        if(cnt1 > n/3) ans.add(ele1);
        if(cnt2 > n/3) ans.add(ele2);
        return ans;
    }
    static List<Integer> elementsMoreThanN_by3(int[] arr){
        List<Integer> a = new ArrayList<>();
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        for(int i = 0;i<arr.length;i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0)+1);
        }
        int req = n/3;
        for(int i = 0;i<arr.length;i++){
            if(mp.get(arr[i])>req) {
                if(!a.contains(arr[i]))
                    a.add(arr[i]);
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(elementsMoreThanN_by3(arr));
        System.out.println(elementsMoreThanNBy3_optimized(arr));
        sc.close();
    }
    
}
