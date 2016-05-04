package main;

/**
 * Created by ysun on 4/26/16.
 */
public class RangeSearch {
    public int[] getRange(int[] nums, int target) {
        int[] range = new int[2];
        if ( nums == null || nums.length == 0 ) {
            return new int[]{-1 , -1}; // returning -1 -1
        }
        int start = 0, end = nums.length - 1;

        // search for the right bound
        while (start + 1 < end) {
            int mid;
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            range[0] = start;
        } else if (nums[end] == target) {
            range[0] = end;
        } else {
            return new int[]{-1, -1};
        }

        // search for the left bound
        start = 0;              // not initiate, but giving new value
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid;
            mid = start + (end - start) / 2;
            if (nums[mid] == target ){
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            range[1] = start;
        } else if (nums[end] == target) {
            range[1] = end;
        } else {
            return new int[]{-1, -1};
        }
        return range; // return statement
    }
}

