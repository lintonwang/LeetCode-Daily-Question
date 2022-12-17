package _202212;

public class CanChoose1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0, j = 0;
        while (i < groups.length && j < nums.length) {
            if (match(groups[i], nums, j)) {
                j += groups[i].length;
                i++;
            } else j++;
        }
        return i == groups.length;
    }

    boolean match(int[] group, int[] nums, int start) {
        if(start+group.length>nums.length)return false;
        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[start + i]) return false;
        }
        return true;
    }
}
