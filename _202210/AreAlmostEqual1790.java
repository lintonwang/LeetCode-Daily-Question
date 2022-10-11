package _202210;

public class AreAlmostEqual1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int diffCount = 0;
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
                if (idx1 == -1) idx1 = i;
                else if (idx2 == -1) idx2 = i;
            }
        }
        if (diffCount == 0) return true;
        else if (diffCount == 1) return false;
        return s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1);
    }
}
