package _202208;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int size = entry.getKey();
            List<Integer> list = entry.getValue();
            int num = list.size();
            for (int i = 0; i < num / size; i++) {
                List<Integer> group = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    group.add(list.get(i * size + j));
                }
                ans.add(group);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        GroupThePeople groupThePeople = new GroupThePeople();
        groupThePeople.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
    }
}
