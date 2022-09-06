package _202209;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueLetterString828 {
    public int uniqueLetterString(String s) {
        //对每一个字符单独计算贡献值，对于字符 c_i ， 记同字符上一次出现的位置为 c_j ，下一次出现的位置为 c_k ，那么这样的子字符串就一共有
        //(c_i-c_j)*(c_k-c_i)个
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                List<Integer> list = new ArrayList<>();
                //为了便于计算，使所有字符第一个出现位置为-1
                list.add(-1);
                map.put(s.charAt(i), list);
            }
            map.get(s.charAt(i)).add(i);
        }
        int ans = 0;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            //为了便于计算，使所有字符最后一个出现位置为字符串最后位置
            list.add(s.length());
            for (int i = 1; i < list.size() - 1; i++) {
                ans += (list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i));
            }
        }
        return ans;
    }
}
