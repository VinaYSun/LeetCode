package Java;

/**
 * Created by ysun on 5/15/16.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean [][] f = new boolean[s1.length() + 1][s2.length() + 1];
        f[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            if (f[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = true;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (f[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                f[0][j] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if ((f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1) || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)))) {
                    f[i][j] = true;
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
