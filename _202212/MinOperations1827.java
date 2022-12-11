package _202212;

public class MinOperations1827 {
    public int minOperations(int[] nums) {
        int count = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < pre + 1) {
                count += pre + 1 - nums[i];
                pre = pre + 1;
            } else pre = nums[i];
        }
        return count;
    }
}
