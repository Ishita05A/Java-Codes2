package Day247;
import java.util.*;
public class SortkSortedArray {
    static  List<Integer> sort(List<Integer> a,int k){
        int n = a.size();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0;i<=k && i<n;i++){
            heap.add(a.get(i));
        }
        List<Integer> res = new ArrayList<>();
        for(int i = k+1;i<n;i++){
            res.add(heap.poll());
            heap.add(a.get(i));
        }
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(6, 5, 3, 2, 8, 10, 9);
        int k = 3;
        System.out.println(sort(arr, k));

    }
    
}
