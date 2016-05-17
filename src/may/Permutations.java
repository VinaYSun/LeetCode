package may;

import java.util.ArrayList;

/**
 * Created by ysun on 5/16/16.
 */
public class Permutations {
    // recursive
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(result, list, nums);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, ArrayList<Integer> nums) {
        if (list.size() == nums.size()) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (Integer i : nums) {
            if (list.contains(i)) {
                continue;
            }
            list.add(i);
            helper(result, list, nums);
            list.remove(list.size() - 1);
        }

    }
    // non recursive
    public ArrayList<ArrayList<Integer>> permuteNonRec(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        int n = nums.size();
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(-1);

        while (list.size() != 0) {
            Integer last = list.get(list.size() - 1);
            list.remove(list.size() - 1);

            // increase the last number
            int next = -1;
            for (int i = last + 1; i < n; i++) {
                if (!list.contains(i)) {
                    next = i;
                    break;
                }
            }
            if (next == -1) {
                continue;
            }

            // generate the next permutation
            list.add(next);
            for (int i = 0; i < n; i++) {
                if (!list.contains(i)) {
                    list.add(i);
                }
            }

            // copy to permutations set
            ArrayList<Integer> permutation = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                permutation.add(nums.get(list.get(i)));
            }
            result.add(permutation);
        }
        return result;
    }
}
