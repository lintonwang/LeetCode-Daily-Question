package _202210;

import java.util.Arrays;
import java.util.Comparator;

public class CustomSortString791 {
    public String customSortString(String order, String s) {
        int[] orderArray = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArray[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            chars[i] = s.charAt(i);
        }
        Arrays.sort(chars, Comparator.comparingInt(a -> orderArray[a - 'a']));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
