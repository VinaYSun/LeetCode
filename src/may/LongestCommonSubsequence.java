package may;

/**
 * Created by ysun on 5/13/16.
 */
public class LongestCommonSubsequence {
    public int getLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int f[][] = new int[m + 1][n + 1];
        for (int i = 0; i <=m; i++) {
            f[i][0] = 0;
        }
        for (int j = 0; j <=n; j++) {
            f[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }
        }
        return f[m][n];
    }

}
