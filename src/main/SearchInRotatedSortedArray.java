package main;

/**
 * Created by ysun on 5/2/16.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        // write your code here
        if (A.length == 0 || A == null) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            // 左列 增序
            if (A[start] < A[mid]) {
                if (A[start] <= target && target <= A[mid]) {
                    // target 在增序的左列
                    end = mid;
                } else {
                    // target 在右列
                    start = mid;
                }
            } else {
                // 右列 增序
                if (A[mid] <= target && target <= A[end]) {
                    // target 在增序的右列
                    start = mid;
                } else {
                    // target 在左列
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }
        return -1;
    }
}
