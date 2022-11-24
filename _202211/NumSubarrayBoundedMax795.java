package _202211;

public class NumSubarrayBoundedMax795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countLowerSubArray(nums, right) - countLowerSubArray(nums, left - 1);
    }

    int countLowerSubArray(int[] nums, int floor) {
        int sum = 0;
        int curr = 0;
        for (int num : nums) {
            if (num <= floor) curr += 1;
            else curr = 0;
            sum += curr;
        }
        return sum;
    }
}
