package Java;

/**
 * Created by ysun on 5/18/16.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int m = A.length;
        int n = B.length;
        int k = m + n;
        if (k % 2 == 0) {
            return (findKth(A, 0, B, 0, k / 2) + findKth(A, 0, B, 0, k / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, k / 2 + 1);
        }
    }

    private static int findKth(int[] A, int astart, int[] B, int bstart, int k) {
        if (astart >= A.length) {
            return B[bstart + k - 1];
        }
        if (bstart >= B.length) {
            return A[astart + k - 1];
        }
        if (k == 1) {
            return Math.min(A[astart], B[bstart]);
        }

        int Akey = astart + k / 2 - 1 < A.length ? A[astart + k / 2 - 1] : Integer.MAX_VALUE;
        int Bkey = bstart + k / 2 - 1 < B.length ? B[bstart + k / 2 - 1] : Integer.MAX_VALUE;

        if (Akey < Bkey) {
            return findKth(A, astart + k / 2, B, bstart, k - k / 2);
        } else {
            return findKth(A, astart, B, bstart + k / 2, k - k / 2);
        }
    }
}
