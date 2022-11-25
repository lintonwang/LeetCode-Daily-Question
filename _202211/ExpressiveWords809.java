package _202211;

public class ExpressiveWords809 {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isMatch(s, word)) count++;
        }
        return count;
    }

    boolean isMatch(String s, String word) {
        int i = 0, j = 0;
        int m = s.length(), n = word.length();
        while (i < m && j < n) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            char c = s.charAt(i);
            int cntI = 0;
            while (i < m && s.charAt(i) == c) {
                cntI++;
                i++;
            }
            c = word.charAt(j);
            int cntJ = 0;
            while (j < n && word.charAt(j) == c) {
                cntJ++;
                j++;
            }
            if (cntI < cntJ) return false;
            if (cntI != cntJ && cntI < 3) return false;
        }
        return i == m && j == n;
    }
}
