package main;

/**
 * Created by ysun on 5/3/16.
 */
public class WoodCut {
    /**
     *
     * @param woodlength
     * @param k
     * @return
     */
    private int getNum(int woodlength, int[] wood) {
        int result = 0;
        for (int i = 0; i < wood.length; i++) {
            result += wood[i] / woodlength;
        }
        return result;
    }

    public int woodCut(int[] L, int k) {
        int maxLength = 0;
        // get the max length -- the max in woods, none should exceed the longest wood
        for (int i = 0; i < L.length; i++) {
            maxLength = Math.max(maxLength, L[i]);
        }

        int start = 1;
        int end = maxLength;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getNum(mid, L) >= k) {
                // looking for the largest, so move range left to mid
                // 长度越小，k越大
                start = mid;
            } else {
                // 长度越大，k越小
                end = mid;
            }
        }
        // end should come the first place
        if (getNum(end, L) >= k) {
            return end;
        }
        if (getNum(start, L) >= k) {
            return start;
        }
        return 0;
    }
}
