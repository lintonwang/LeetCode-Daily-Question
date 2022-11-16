package _202211;

public class IsIdealPermutation775 {
    public boolean isIdealPermutation(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - i) >= 2) return false;
        }
        return true;
    }


}
