package Day159;
import java.util.*;


public class N_MeetingInARoom {
    static class Meeting{
        int start;
        int end;
        Meeting(int start,int end){
            this.start = start;
            this.end = end;
        }
    }
    static List<Integer> noOfMeeting(int[] start,int[] end){
        int n = start.length;
        int count = 0;
        List<Meeting> arr = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            arr.add(new Meeting(start[i], end[i]));
        }
        arr.sort(Comparator.comparingInt(m->m.end));
        int lastEnd = -1;
        int idx = 0;
        for(Meeting meet : arr){
            if(meet.start >lastEnd){
                lastEnd = meet.start;
                count= count+1;
                ans.add(idx+1);
            }
            idx++;
        }
        return ans;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter elements for weight");
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.nextInt();
        }
        System.out.println(noOfMeeting(arr, s));
        sc.close();
    }
    
}
