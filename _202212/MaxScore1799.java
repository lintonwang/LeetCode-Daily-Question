package _202212;

public class MaxScore1799 {
    public int maxScore(int[] nums) {
        int m = nums.length;
        int[][] gcdTmp = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                gcdTmp[i][j] = gcd(nums[i], nums[j]);
            }
        }
        int origin = 1 << m;
        int[] dp = new int[1 << m];
        for (int s = 1; s < origin; s++) {
            int bit = Integer.bitCount(s);

            for (int i = 0; i < m; i++) {
                if (((s >> i) & 1) != 0) {
                    for (int j = i + 1; j < m; j++) {
                        if (((s >> j) & 1) != 0) {
                            dp[s] = Math.max(dp[s], dp[s ^ (1 << i) ^ (1 << j)] + bit / 2 * gcdTmp[i][j]);
                        }
                    }
                }
            }

        }
        return dp[origin - 1];
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
