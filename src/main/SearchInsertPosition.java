package main;

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
        if (nums.length == 0){
            return 0;
        }
        int start, end;
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target ){
                end = mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target){
            return end;
        } else if (nums[end] < target) {
            return end + 1;
        } else if (nums[start] < target){
            return start + 1;
        } else {
            return start;
        }
    }
}
