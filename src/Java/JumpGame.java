package Java;

/**
 * Created by ysun on 5/12/16.
 */
public class JumpGame {
    // greedy vs DP : O(n) vs O(n^2)
    public boolean canJump(int[] A) {
        boolean[] can = new boolean[A.length];
        // start
        can[0] = true;
        // state & function
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[A.length - 1];
    }

    public boolean canJumpII(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }
        // calculate the largest place it can get
        int farthest = A[0];
        for (int i = 1; i < A.length; i++) {
            // update farthest
            if (i <= farthest && A[i] + i >= farthest) {
                farthest = A[i] + i;
            }
        }
        return farthest >= A.length - 1;
    }


}
