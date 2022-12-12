package _202212;

public class BeautySum1781 {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int max = 0;
            for (int j = i; j < n; j++) {
                cnt[s.charAt(j) - 'a']++;
                max = Math.max(max, cnt[s.charAt(j) - 'a']);
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 0) min = Math.min(min, cnt[k]);
                }
                res += max - min;
            }
        }
        return res;
    }
}
