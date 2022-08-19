import java.util.Arrays;

public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int max = Arrays.stream(endTime).max().getAsInt();
        if (queryTime > max) return 0;
        int[] diff = new int[max + 2];
        for (int i = 0; i < n; i++) {
            diff[startTime[i]]++;
            diff[endTime[i] + 1]--;
        }
        int ans = 0;
        for (int i = 0; i <= queryTime; i++) {
            ans += diff[i];
        }
        return ans;
    }
}
