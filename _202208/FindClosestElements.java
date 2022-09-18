package _202208;

import java.util.ArrayList;
import java.util.List;

public class FindClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] >= x) right = mid;
            else left = mid + 1;
        }
        List<Integer> ans = new ArrayList<>();
        right = left;
        left -= 1;
        for (int i = 0; i < k; i++) {
            if (left < 0) right++;
            else if (right >= arr.length) left--;
            else {
                if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) right++;
                else left--;
            }
        }
        for (int i = left + 1; i < right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        FindClosestElements func = new FindClosestElements();
        func.findClosestElements(new int[]{1, 5, 10}, 1, 4);
    }
}
