package _202211;

public class Check1752 {
    public boolean check(int[] nums) {
        int broad = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                broad = i;
                break;
            }
        }
        if (broad == -1) return true;
        for (int i = broad + 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return nums[0] >= nums[nums.length - 1];
    }
}
