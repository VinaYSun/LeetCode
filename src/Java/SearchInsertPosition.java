package Java;

/**
 * Created by ysun on 4/28/16.
 */
public class SearchInsertPosition {
    /**
     * input: a sorted array, a integer to be inserted
     * @Return: index where it would be inserted in order
     *
     * assuming there is no duplicates in the array
     *
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        if (nums[start] > target) {
            return start;
        }
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
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
        if (nums[end] < target) {
            return end + 1;
        }
        return start + 1;
    }
}
