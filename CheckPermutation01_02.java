public class CheckPermutation01_02 {
    public boolean CheckPermutation(String s1, String s2) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            char2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (char1[i] != char2[i]) return false;
        }
        return true;
    }
}
