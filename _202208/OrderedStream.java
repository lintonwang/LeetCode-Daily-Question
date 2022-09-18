package _202208;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
    String[] strings;
    int ptr;

    public OrderedStream(int n) {
        strings = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        strings[idKey] = value;
        List<String> ans = new ArrayList<>();
        while (ptr < strings.length && strings[ptr] != null) {
            ans.add(strings[ptr]);
            ptr++;
        }
        return ans;
    }
}
