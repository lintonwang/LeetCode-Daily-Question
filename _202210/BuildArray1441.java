package _202210;

import java.util.ArrayList;
import java.util.List;

public class BuildArray1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList();
        for (int i = 1, j = 0; i <= n && j < target.length; ++i) {
            if (target[j] == i) {
                ans.add("Push");
                ++j;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }
}
