package _202211;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates816 {
    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length() - 1);
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < s.length(); i++) {
            List<String> left = split(s.substring(0, i));
            List<String> right = split(s.substring(i));
            if (left.isEmpty() || right.isEmpty()) continue;
            for (String l : left) {
                for (String r : right) {
                    ans.add("(" + l + ", " + r + ")");
                }
            }
        }
        return ans;
    }

    List<String> split(String str) {
        List<String> ans = new ArrayList<>();
        if (str.charAt(0) != '0' || "0".equals(str)) ans.add(str);
        for (int i = 1; i < str.length(); i++) {
            if ((i != 1 && str.charAt(0) == '0') || str.charAt(str.length() - 1) == '0') continue;
            ans.add(str.substring(0, i) + "." + str.substring(i));
        }
        return ans;
    }
}
