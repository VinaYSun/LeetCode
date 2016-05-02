package main;

/**
 * Created by ysun on 5/1/16.
 */
class ArrayReader {
    // get the number at index, return -1 if not exists.
    public int get(int index) {
        return 0; // for compile reason returning 0
    };
}
public class SearchInABigSortedArray {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        int index = 1;
        while (reader.get(index - 1) < target && reader.get(index - 1) != -1) {
            index = index * 2;
        }
        int start = 0;
        int end = index - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) == target) {
                end = mid;
            } else if (reader.get(mid) < target && reader.get(mid) != -1){ // condition check for -1 is important
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        }
        return -1;
    }
}
