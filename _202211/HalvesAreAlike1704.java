package _202211;

public class HalvesAreAlike1704 {
    public boolean halvesAreAlike(String s) {
        String before = s.substring(0, s.length() / 2);
        String after = s.substring(s.length() / 2);
        String meta = "aeiouAEIOU";
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (meta.indexOf(before.charAt(i)) >= 0) count1++;
            if (meta.indexOf(after.charAt(i)) >= 0) count2++;
        }
        return count1 == count2;
    }
}
