package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ysun on 5/1/16.
 */
public class SubSetII {
    /**
     * Recursive
     *
     */

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(S == null) {
            return result;
        }
        Arrays.sort(S);
        helperFunctionDFS(result, list, 0, S);
        return result;
    }

    public void helperFunctionDFS(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int index, int[] S) {
        /**
         * This won't pass for the test input [0]
         * -- result.add(list)
         */
        // list是空的时候，也要新建一个[]
        result.add(new ArrayList<Integer>(list)); // this passed the test
//        result.add(list);
        for (int i = index; i < S.length; i++) {
            if(i != index && S[i] == S[i - 1]) {
                continue;
            }
            list.add(S[i]);
            helperFunctionDFS(result, list, i+1, S);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] S = new int[]{0};

        SubSetII ss = new SubSetII();
        ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
        l = ss.subsetsWithDup(S);
    }
}
