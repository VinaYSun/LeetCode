package main;

import java.util.ArrayList;

/**
 * Created by ysun on 5/18/16.
 */
public class MaximumSubarray {
    // greedy
    public int maxSubArray(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }
        return max;
    }
    // DP
    public int maxSubArrayDP(int[] nums) {
        // write your code
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    public int maxSubArray(ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int n = nums.size();
        int[] global = new int[n];
        int[] local = new int[n];
        global[0] = nums.get(0);
        local[0] = nums.get(0);
        for (int i = 1; i < n; i++) {
            local[i] = Math.max(nums.get(i), local[i - 1] + nums.get(i));
            global[i] = Math.max(local[i], global[i - 1]);
        }
        return global[n - 1];
    }

}
