package _202211;

import java.util.Arrays;

public class SumSubseqWidths891 {

    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long MOD = (long) 1e9 + 7;
        long maxSum = 0, minSum = 0;
        for (int i = 0; i < n; i++) {
            minSum = (minSum * 2 + nums[i]) % MOD;
            maxSum = (maxSum * 2 + nums[n - i - 1]) % MOD;
        }
        return (int) ((maxSum + MOD - minSum) % MOD);
    }

}
