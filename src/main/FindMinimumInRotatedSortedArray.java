package main;

/**
 * Solution is copied from NineChapter
 *
 * Created by ysun on 5/2/16.
 *
 * No Duplicates in the array
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0, end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] <= num[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (num[start] <= num[end]) {
            return num[start];
        }
        if (num[end] <= num[end]) {
            return num[end];
        }
        return -1;
    }
}
