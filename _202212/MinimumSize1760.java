package _202212;

import java.util.Arrays;

public class MinimumSize1760 {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = Arrays.stream(nums).max().getAsInt();
        while (left < right) {
            int mid = (left + right) / 2;
            int ops = 0;
            for (int num : nums) {
                ops += (num - 1) / mid;
            }
            if (ops <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
