package main;

import java.util.HashMap;

/**
 *
 */
public class TwoSum {
    public int[] TwoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                int[] result = {map.get(nums[i]), i + 1};
                return result;
            } else {
                map.put(target - nums[i], i);
            }
        }
        int[] result = {};
        return result;
    }
}
