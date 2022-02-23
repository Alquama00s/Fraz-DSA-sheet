import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    static class comp implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        }
    }

    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        if (intervals.length == 1)
            return intervals;

        Arrays.sort(intervals, new comp());
        int itr1 = 0, itr = 0, closeMax = intervals[0][1];
        while (itr < intervals.length - 1) {
            if (closeMax >= intervals[itr + 1][0]) {
                closeMax = Math.max(closeMax, intervals[itr + 1][1]);
                itr++;
            } else {
                ans.add(new int[] { intervals[itr1][0], closeMax });
                itr++;
                closeMax = intervals[itr][1];
                itr1 = itr;
            }
            if (itr == intervals.length - 1) {
                ans.add(new int[] { intervals[itr1][0], closeMax });
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
