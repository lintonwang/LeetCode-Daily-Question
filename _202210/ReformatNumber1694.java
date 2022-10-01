package _202210;

import java.util.ArrayList;
import java.util.List;

public class ReformatNumber1694 {
    public String reformatNumber(String number) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) list.add(number.charAt(i));
        }
        int range = 3;
        int idx = 0;
        StringBuffer sb = new StringBuffer();
        while (idx < list.size() - 4) {
            for (int i = 0; i < range; i++) {
                sb.append(list.get(idx + i));
            }
            sb.append("-");
            idx += range;
        }
        if (list.size() - idx < 4) {
            for (int i = idx; i < list.size(); i++) sb.append(list.get(i));
        } else if (idx == list.size() - 1) {
            sb.deleteCharAt(idx);
        } else {
            for (int i = 0; i < 2; i++) {
                sb.append(list.get(idx + i));
            }
            idx += 2;
            sb.append("-");
            for (int i = 0; i < 2; i++) {
                sb.append(list.get(idx + i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReformatNumber1694 reformatNumber1694 = new ReformatNumber1694();
        reformatNumber1694.reformatNumber("123 4-567");
    }
}
