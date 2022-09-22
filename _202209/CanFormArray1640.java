package _202209;

import java.util.HashMap;
import java.util.Map;

public class CanFormArray1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length; ) {
            if (map.containsKey(arr[i])) {
                int idx = map.get(arr[i]);
                for (int j = 0; j < pieces[idx].length; j++) {
                    if (arr[i] != pieces[idx][j]) return false;
                    i++;
                }
            } else return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CanFormArray1640 canFormArray1640 = new CanFormArray1640();
        canFormArray1640.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}});
    }
}
