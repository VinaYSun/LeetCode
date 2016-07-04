package Java;

/**
 * [[1, 2, 3, 5], [7, 8, 10, 13],[14, 15, 19, 20]]
 *
 * matrix[0] = [1, 2, 3, 5]
 * matrix[0][0] = [1]
 *
 * matrix[1] = [7, 8 ,10, 13]
 *
 */
// A coordinate transformation: 坐标变换
// virtualIndex Max -> row * col - 1 (end)
    //          Min -> 0 (start)
    // num[virtualIndex/column][virtualIndex % column] -> num["mid"]
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, column = matrix[0].length;
        int start = 0, end = row * column - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int midvalue = matrix[mid / column][mid % column];
            if (midvalue == target) {
                return true;
            } else if (midvalue < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[start / column][start % column] == target) {
            return true;
        } else if (matrix[end / column][end % column] == target) {
            return true;
        }
        return false;
    }
}
