package _202210;

import java.util.Arrays;

public class MaxRepeating1668 {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n];
        for (int i = m - 1; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (sequence.charAt(i - m + j + 1) != word.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) dp[i] = (i == m - 1 ? 0 : dp[i - m]) + 1;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
