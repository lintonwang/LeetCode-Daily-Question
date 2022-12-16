package _202212;

import java.util.Arrays;

public class MinElements1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) sum += num;
        long diff = Math.abs(sum - goal);
        return (int) ((diff + limit - 1) / limit);
    }
}
