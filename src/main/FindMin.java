package main;

/**
 * Solution is copied from NineChapter
 *
 * Created by ysun on 5/2/16.
 */
public class FindMin {

    public int findMin(int[] num) {
        // find the FIRST element that is smaller than End of NUM
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0, end = num.length - 1;
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
        }
        if (num[end] <= target) {
            return num[end];
        }
        return -1;
    }
}
