package may;

/**
 * Reach the end , with minimum number of jumps.
 */
public class JumpGameII {
    // Greedy vs DP
    public int jump(int[] A) {
        // take int[i] steps to get to A[i]
        int[] steps = new int[A.length];
        // start
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[j] = steps[j] + 1;
                    break;
                }
            }
        }
        return steps[A.length - 1];
    }

    public int jumpTwo(int[] A) {
        if ( A == null || A.length == 0) {
            return -1;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < A.length - 1) {
            jumps++;
            int fartest = end;
            for (int i = start; i <= end; i++) {
                if (A[i] + i > fartest) {
                    fartest = A[i] + i;
                }
            }
            start = end + 1;
            end = fartest;
        }
        return jumps;
    }
}
