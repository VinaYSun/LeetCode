package Java;

/**
 * Created by ysun on 6/16/16.
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int[][] f = new int[obstacleGrid.length][obstacleGrid[0].length];

        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                f[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] != 1) {
                f[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                } else {
                    f[i][j] = 0;
                }
            }
        }

        return f[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
