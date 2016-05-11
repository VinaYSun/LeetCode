package main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while ( i < nums.length - 1 && nums[i] == nums[i+1] - 1){
                i++;
            }
            if (nums[i] == start){
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[i]);
            }
        }
        return result;
    }
}

