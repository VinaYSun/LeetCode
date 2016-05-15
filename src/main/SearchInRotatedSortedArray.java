package main;

/**
 * Created by ysun on 5/2/16.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                if (A[mid] >= target && target >= A[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[end] >= target && target >= A[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target){
            return end;
        }
        return -1;

    }
}
