package main;

/**
 * Created by ysun on 5/31/16.
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }

        int start = 0;
        int end = A.length - 1;
        // if no duplicates
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return true;
            }
            if (A[mid] == A[end]) {
                end--;
            } else if (A[mid] < A[end]) {
                if (target > A[mid] && target < A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (A[mid] > A[end]) {
                if (target > A[start] && target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
        }
        if (A[start] == target || A[end] == target) {
            return true;
        }
        return false;
    }

    // inspired by Jiuzhang
    // The trick is worst case for binary search above would be O(n) like [1, 1, 1, 1 ... 1]
    // So using a for loop will have the same performance.
    public boolean searchII(int[] A, int target) {
        for (int i = 0; i < A.length; i ++) {
            if (A[i] == target) {
                return true;
            }
        }
        return false;
    }
}
