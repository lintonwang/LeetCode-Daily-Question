package _202210;

import java.util.Arrays;

public class ThreeEqualParts927 {
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) return new int[]{-1, -1};
        if (sum == 0) return new int[]{0, 2};
        int partial = sum / 3;
        int zeroCnt = 0, first = -1, second = -1, third = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (zeroCnt == 0) {
                    first = i;
                } else if (zeroCnt == partial) {
                    second = i;
                } else if (zeroCnt == partial * 2) {
                    third = i;
                }
                zeroCnt++;
            }
        }
        int len = arr.length - third;
        for (int i = 1; i < len; i++) {
            if (arr[first + i] != arr[second + i] || arr[second + i] != arr[third + i]) return new int[]{-1, -1};
        }
        return new int[]{first + len - 1, second + len};
    }
}
