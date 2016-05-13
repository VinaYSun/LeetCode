package may;

/**
 * Created by ysun on 5/12/16.
 */
public class LongestIncreasingSubsequence {
    // DP
    public int longestIncreasingSubsequence(int[] nums) {
        int f[] = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) { // 行前往后
                if (nums[j] <= nums[i]) { // 从低到高
                    //max{f[j] + 1}; j < i; nums[j] <= nums[i]
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
            // max{f[i]}
            if (f[i] > max) {
                max = f[i];
            }
        }
        return max;
    }
}
