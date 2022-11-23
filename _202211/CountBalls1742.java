package _202211;

import java.util.HashMap;
import java.util.Map;

public class CountBalls1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int box = 0;
            int ball = i;
            while (ball != 0) {
                box += ball % 10;
                ball /= 10;
            }
            map.put(box, map.getOrDefault(box, 0) + 1);
            max = Math.max(max, map.get(box));
        }
        return max;
    }
}
