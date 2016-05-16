package main;

/**
 * Created by ysun on 5/3/16.
 */
public class FindPeak {
    /**
     * An integer array has the following features
     * - numbers in adjacent positions are different
     * - A[0] < A[1] && A[A.length - 2] > A[A.length - 1]
     *
     * Find a Peak that satisfies A[p] > A[p-1] && A[p] > A[p+1] in the array.
     * (the array may contains multiple peaks, find any of them)
     *
     *
     * start取第二位；end取倒数第二位
     * int[mid] < int[mid + 1] start = mid
     * int[mid] < int[mid - 1] end = mid
     *
     * int[start] < int[end] return end
     *
     */
    public int findPeak(int[] A) {
        int start = 1, end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
