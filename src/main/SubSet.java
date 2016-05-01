package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ysun on 5/1/16.
 */
public class SubSet {
    /**
     * Recursive way
     * 1. sort
     * 2. helperFunctionDFS
     */
    public List<List<Integer>> subSet(int[] S){
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (S == null) {
            return ret;
        }

        Arrays.sort(S);

        ArrayList<Integer> path = new ArrayList<Integer>();
        helperFunctionDFS(S, 0, path, ret);

        return ret;
    }

    public void helperFunctionDFS(int[] S, int index, ArrayList<Integer> path, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(path));

        for (int i = index; i < S.length; i++) {
            path.add(S[i]);
            helperFunctionDFS(S, i + 1, path, ret);
            path.remove(path.size() - 1);
        }
    }

    /**
     *
     * @param nums
     */
    public ArrayList<ArrayList<Integer>> subSetTwo(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);

        /**
         * 排列组合：具有n个元素的集合S[n]，有2^n个子集
         * 元素个数  子集数
         * 1         2
         * 2         4
         * 3         8
         * ...
         * n         2^n
         *
         * 每一个子集，映射一个独立的二进制数，映射法则
         *
         *  子集A: [S[n1], S[n2]]  ->   10001000
         *
         *   n1 = 3, n2 = 7
         *
         */

        // 1 << n is 2^n
        // each subset equals to an binary integer between 0.. 2^n-1  (n=nums.length)
        // 0 = 000 -> nums[]
        // 1 = 001 -> nums[0]
        // 2 = 010 -> nums[1]
        // 3 = 011 -> nums[0], nums[1]
        // 4 = 100 -> nums[2]
        // 5 = 101 -> nums[0], nums[2]
        // 6 = 110 -> nums[1], nums[2]
        // 7 = 111 -> nums[1], nums[2], nums[0]

        for (int i = 0; i < (1<<n); i++) {
            ArrayList<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                // j （左移乘2）
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] S = {1, 5, 6};

        SubSet ss = new SubSet();
        ss.subSet(S);

        ss.subSetTwo(S);

        int a = 3;
        System.out.println(" 1<< n" + (1<<a));

    }

}
