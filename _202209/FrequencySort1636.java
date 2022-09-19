package _202209;

import java.util.*;

public class FrequencySort1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count1 = count.get(o1);
                int count2 = count.get(o2);
                return count1 != count2 ? count1 - count2 : o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
