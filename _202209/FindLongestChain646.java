package _202209;

import java.util.Arrays;

public class FindLongestChain646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (int[] a, int[] b) -> (a[1] - b[1]));
        int curr = Integer.MIN_VALUE;
        int count = 0;
        for (int[] pair : pairs) {
            if (curr < pair[0]) {
                count++;
                curr = pair[1];
            }
        }
        return count;
    }
}
