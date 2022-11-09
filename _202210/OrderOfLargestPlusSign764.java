package _202210;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OrderOfLargestPlusSign764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        Set<Integer> zero = new HashSet<>();
        int max = 0;
        for (int[] mine : mines) zero.add(mine[0] * n + mine[1]);
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (zero.contains(i * n + j)) count = 0;
                else count++;
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (zero.contains(i * n + j)) count = 0;
                else count++;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (zero.contains(j * n + i)) count = 0;
                else count++;
                dp[j][i] = Math.min(dp[j][i], count);
            }
            count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (zero.contains(j * n + i)) count = 0;
                else count++;
                dp[j][i] = Math.min(dp[j][i], count);
                max = Math.max(dp[j][i], max);
            }
        }
        return max;
    }
}
