package main;

/**
 * Solution is copied from NineChapter
 *
 * Created by ysun on 5/2/16.
 */
public class FindMin {
    /**
     * An array, is rotated. Find the minimum element.
     *
     * i.e. 4 5 6 7 0 1 2
     * return 0
     *
     * target == int[end]
     * int[mid] <, >, = target : end, start, end = mid
     * int[start] < int[end] , return start
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        int target = num[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] <= target) {
            return num[start];
        } else {
            return num[end];
        }
    }
}
