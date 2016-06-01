package main;

/**
 * Array may have duplicates
 *
 * Created by ysun on 5/29/16.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // corner case, mid == end, move pointer one position ahead
            if (num[mid] == num[end]) {
                end--;
            } else if (num[mid] < num[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (num[end] <= num[start]) {
            return num[end];
        }
        if (num[end] > num[start]) {
            return num[start];
        }
        return -1;
    }
}
