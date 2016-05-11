package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 几处边界条件：
 * 1. 长度为零，返回空
 * 2. 长度为1，返回唯一值
 * 3. 循环从第二位开始
 *
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                if (i == nums.length - 1) {
                    result.add(start + "->" + nums[i]);
                }
            } else {
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }

                if (i == nums.length - 1) {
                    result.add(nums[i] + "");
                }

                start = nums[i];
            }
            end = nums[i];
        }
        return result;
    }
}

