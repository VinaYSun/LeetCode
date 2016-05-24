package may;

/**
 * Created by ysun on 5/23/16.
 */
public class TotalOccurrenceOrTarget {
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        int[] range = new int[2];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] == target) {
            range[0] = start;
        } else if (A[end] == target) {
            range[0] = end;
        } else {
            return 0;
        }

        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            range[1] = end;
        } else if (A[start] == target) {
            range[1] = start;
        } else {
            return 0;
        }


        return (range[1] - range[0] + 1);

    }
}
