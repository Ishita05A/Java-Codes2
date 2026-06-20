package Day227;

import java.util.*;
public class NmeetingInARoom {
    static class data{
        int s;
        int e;
        int pos;
        data(int st,int end,int pos){
            this.s = st;
            this.e = end;
            this.pos = pos;
        }
    }
    static List<Integer> maxMeeting(int[] st,int[] end){
        int n = st.length;
        data[] arr = new data[n];
        for(int i = 0;i<n;i++){
            arr[i] = new data(st[i], end[i], i+1);
        }
        Arrays.sort(arr,(a,b)->a.e-b.e);

        List<Integer> aa = new ArrayList<>();
        aa.add(arr[0].pos);
        int free = arr[0].e;
        for(int i = 1;i<n;i++){
            if(arr[i].s > free){
                aa.add(arr[i].pos);
                free = arr[i].e;
            }
        }
        return aa;
    }
    public static void main(String[] args) {
        int[] start= {1,3,0,5,8,5};
        int[] end =  {2,4,5,7,9,9};
        System.out.println(maxMeeting(start, end));

    }
    
}
