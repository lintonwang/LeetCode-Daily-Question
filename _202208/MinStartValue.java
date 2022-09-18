package _202208;

import java.util.Arrays;

public class MinStartValue {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int min = Arrays.stream(preSum).min().getAsInt();
        return min >= 1 ? 1 : 1 - min;

    }

    public static void main(String[] args) {

    }
}
