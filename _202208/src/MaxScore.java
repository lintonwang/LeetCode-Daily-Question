public class MaxScore {
    public int maxScore(String s) {
        int maxScore = 0;
        for (int i = 1; i < s.length() ; i++) {
            int a = getScore(s.substring(0, i), '0');
            int b = getScore(s.substring(i), '1');
            maxScore = Math.max(maxScore, a + b);
        }
        return maxScore;
    }

    int getScore(String str, char bit) {
        int ans = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == bit) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        maxScore.maxScore("00");
    }
}
