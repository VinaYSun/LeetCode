package main;

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * You can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 *
 */
public class FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     * start = 0, end = n
     * start + 1 < end: function(mid) true ; false (end = mid ; sstart = mid)
     * function(start) == true rtn OR function(mid)
     */
    /*
    public int findFirstBadVersion(int n) {
        // write your code here
        int start, end;
        start = 0;
        end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid) == true) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)==true){
            return start;
        } else {
            return end;
        }
    }
    */

}
