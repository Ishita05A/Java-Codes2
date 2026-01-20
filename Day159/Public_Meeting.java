package Day159;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Public_Meeting {
    static class Meeting{
        int start;
        int end;

        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    static int maxMeetings(int start[], int end[], int n) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        meetings.sort(Comparator.comparingInt(m -> m.end));
        int lastEnd = -1;
        int count = 0;

        for (Meeting meet : meetings) {
            if (meet.start > lastEnd) {
                lastEnd = meet.end;
                count++;
            }
        }

        return count;

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
        System.out.println(maxMeetings(arr, s, n));
        sc.close();
    }
    
}
