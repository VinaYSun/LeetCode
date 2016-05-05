package main;

/**
 *
 */
public class Search2DMatrixII {

    /**
     *  each row sorted; each column sorted matrix
     *
     *  1 , 4, 7, 8, 12
     *  2,  5, 8, 9, 15
     *  4,  7, 9, 10, 16
     *  5,  10, 11, 14, 18
     *
     *  O(m + n)
     */
    // return occurrences of a target number in Matrix
    // e.g. given target 10, return true; given target 6 return false
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;

        int x = n - 1;
        int y = 0;

        while (x >= 0 && y < m) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

    // return occurrences of a target number in Matrix
    public int searchMatrixOccur(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;

        int x = n - 1;
        int y = 0;
        int result = 0;

        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] == target) {
                result++;
                x--;
                y++;
            }
        }
        return result;
    }

    // should have another solution, dived and conquer ...
}
