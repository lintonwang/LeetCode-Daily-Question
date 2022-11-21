package _202211;

public class SoupServings808 {
    public double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n >= 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) dp[0][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][j - 1]
                        + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[i - 1][Math.max(j - 3, 0)]) / 4;
            }
        }
        return dp[n][n];
    }
}
