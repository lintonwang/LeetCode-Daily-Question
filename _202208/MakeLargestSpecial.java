package _202208;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public  class MakeLargestSpecial {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2)
            return s;
        int n = s.length();
        int cnt = 0;
        int left = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                cnt++;
            else {
                cnt--;
                if (cnt == 0) {
                    ans.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i + 1;
                }
            }
        }
        Collections.sort(ans, (a, b) -> b.compareTo(a));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < ans.size(); i++) {
            sb.append(ans.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MakeLargestSpecial makeLargestSpecial = new MakeLargestSpecial();
        makeLargestSpecial.makeLargestSpecial("11011000");
    }
}