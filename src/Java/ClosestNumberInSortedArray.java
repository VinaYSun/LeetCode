package Java;

/**
 * Created by ysun on 5/24/16.
 */
public class ClosestNumberInSortedArray {

    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;
        // finding the 1st element that satisfies its value > than target
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid; // because the problem said we can return any elements
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] > target) {
            return 0;
        } else if (A[end] < target) {
            return A.length - 1;
        }

        int diffStart = Math.abs(A[start] - target);
        int diffEnd = Math.abs(A[end] - target);

        if (diffStart > diffEnd) {
            return end;
        }
        return start;
    }
}
