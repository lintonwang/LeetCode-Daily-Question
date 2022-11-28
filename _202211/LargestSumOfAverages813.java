package _202211;

public class LargestSumOfAverages813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] preSum = new double[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        double[][] dp = new double[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = preSum[i] / i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int x = j - 1; x < i; x++)
                    dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (preSum[i] - preSum[x]) / (i - x));
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        LargestSumOfAverages813 solution = new LargestSumOfAverages813();
        solution.largestSumOfAverages(new int[]{1}, 1);
    }
}
