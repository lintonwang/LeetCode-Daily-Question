package _202209;

public class GetKthMagicNumber17_09 {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int three = dp[p3] * 3, five = dp[p5] * 5, seven = dp[p7] * 7;
            dp[i] = Math.min(three, Math.min(five, seven));
            if (dp[i] == three) p3++;
            if (dp[i] == five) p5++;
            if (dp[i] == seven) p7++;
        }
        return dp[k];
    }
}
