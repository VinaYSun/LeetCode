package Java;

/**
 * Created by ysun on 5/28/16.
 */
public class KClosestNumberInSortedArray {
    /**
     * 题目： 找到K个与target“差值”最小的数，以它们与target的差值进行升序排序；若差值相同，则以升序排序
     *
     * 先用二分法，找到与target最接近的大于等于target的第一个数的index
     * 以index为右指针，index左侧为左指针，向左走
     *
     * 注意：
     *  当左指针的diff < 右指针的diff :
     *      存入左指针
     *  当左指针的diff ＝ 右指针的diff :
     *      存入左指针！！依照题目，差值相同升序排列
     *  当左指针的diff > 右指针的diff :
     *      存入右指针
     *  当左指针走到头，就只需要存入右指针
     *  当有指针走到头，就只需要存入左指针
     */


    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int[k];

        if (A == null || A.length == 0) {
            return result;
        }
        if (k > A.length) {
            return A;
        }
        int right = findIndex(A, target);
        int left = right - 1;
        for (int i = 0; i < k; i++) {
            if (left < 0) {
                result[i] = A[right++];
            } else if (right >= A.length) {
                result[i] = A[left--];
            } else {
                if (target - A[left] > A[right] - target) {
                    result[i] = A[right++];
                } else {
                    result[i] = A[left--];
                }
            }
        }
        return result;
    }

    public int findIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] >= target) {
            return start;
        }
        if (A[end] >= target) {
            return end;
        }
        return A.length;
    }
}
