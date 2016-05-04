package main;

/**
 *  time: O(logn)
 *
 */
public class ClassicBinarySearch {

    public int BinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start, end, mid;
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2; // re-calculate mid in every loop
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
