package _202209;

import java.util.Arrays;
import java.util.Comparator;

public class SpecialArray1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        //当x等于 nums.length 时，需要满足nums[0] >= nums.length；
        //当x等于 [1, nums.length - 1] 时，需要满足nums[i] >= (res = nums.length - i) 并且 nums[i - 1] < res；
        int n = nums.length;
        if (nums[0] >= n) return n;
        for (int i = 1; i < n; i++) {
            int count = n - i;
            if (nums[i] >= count && nums[i - 1] < count) return count;
        }
        return -1;
    }
}
