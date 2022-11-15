package _202211;

import java.util.Arrays;

public class MaximumUnits1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int[] box : boxTypes) {
            if (box[0] >= truckSize) {
                ans += truckSize * box[1];
                return ans;
            } else {
                ans += box[0] * box[1];
                truckSize -= box[0];
            }
        }
        return ans;
    }
}
