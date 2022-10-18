package _202210;

public class AtMostNGivenDigitSet902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = String.valueOf(n);
        int len = digits.length;
        int[][] dp = new int[num.length() + 1][2];
        dp[0][1]=1;
        for (int i = 1; i <= num.length(); i++) {
            for (int j = 0; j < len; j++) {
                if (digits[j].charAt(0) == num.charAt(i - 1)) dp[i][1] = dp[i - 1][1];
                else if (digits[j].charAt(0) < num.charAt(i - 1)) dp[i][0] += dp[i - 1][1];
                else break;
            }
            if (i > 1) dp[i][0] = len + dp[i - 1][0] * len;
        }
        return dp[num.length()][0] + dp[num.length()][1];
    }
}
