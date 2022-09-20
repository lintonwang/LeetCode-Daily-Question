package _202209;

import java.util.Arrays;

public class CanPartitionKSubsets698 {
    int k, partSum;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        this.k = k;
        if (sum % k != 0) return false;
        this.partSum = sum / k;
        boolean[] used = new boolean[nums.length];
        return dfs(nums, used, 0, 0, 0);
    }

    boolean dfs(int[] nums, boolean[] used, int begin, int currentGroup, int groupSum) {
        if (currentGroup == this.k) return true;
        if (groupSum == this.partSum) dfs(nums, used, begin + 1, currentGroup + 1, 0);
        for (int i = begin; i < nums.length; i++) {
            if (used[i] || nums[i] + groupSum > this.partSum) continue;
            used[i] = true;
            if (dfs(nums, used, begin + 1, currentGroup, groupSum + nums[i])) return true;
            used[i] = false;
        }
        return false;
    }
}
