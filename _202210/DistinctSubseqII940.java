package _202210;

import java.util.Arrays;

public class DistinctSubseqII940 {
    public int distinctSubseqII(String s) {
        final int MOD = 1000000007;
        int[] last = new int[26];
        int[] dp = new int[s.length() + 1];
        Arrays.fill(last, -1);
        Arrays.fill(dp, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = (dp[i] + dp[last[j]]) % MOD;
                }
            }
            last[s.charAt(i)-'a']=i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                ans = (ans + dp[last[i]]) % MOD;
            }
        }
        return ans;
    }
}
