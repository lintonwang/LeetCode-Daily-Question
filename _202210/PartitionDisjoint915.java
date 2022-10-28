package _202210;

public class PartitionDisjoint915 {
    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        int sep = 0, leftMax = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < leftMax) {
                sep = i;
                leftMax = max;
            }
        }
        return sep + 1;
    }
}
