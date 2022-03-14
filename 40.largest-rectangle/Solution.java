import java.util.*;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 }));
    }

    public int largestRectangleArea(int[] heights) {
        /*
         * monotonic increasing index stack
         */
        Deque<Integer> mStack_index = new ArrayDeque<>();
        int[] leftBound = new int[heights.length];
        int[] rtBound = new int[heights.length];
        // calculating left most bound
        for (int i = 0; i < heights.length; i++) {
            if (mStack_index.isEmpty()) {
                leftBound[i] = 0;
            } else {
                while (!mStack_index.isEmpty() && heights[mStack_index.peek()] >= heights[i]) {
                    mStack_index.pop();
                }
                if (mStack_index.isEmpty()) {
                    leftBound[i] = 0;
                } else {
                    leftBound[i] = mStack_index.peek() + 1;
                }
            }
            mStack_index.push(i);
        }
        mStack_index.clear();
        //calculating right most bound
        for (int i = heights.length - 1; i >= 0; i--) {
            if (mStack_index.isEmpty()) {
                rtBound[i] = heights.length - 1;
            } else {
                while (!mStack_index.isEmpty() && heights[mStack_index.peek()] >= heights[i]) {
                    mStack_index.pop();
                }
                if (mStack_index.isEmpty()) {
                    rtBound[i] = heights.length - 1;
                } else {
                    rtBound[i] = mStack_index.peek() - 1;
                }
            }
            mStack_index.push(i);
        }
        int ans =0;
        for (int i = 0; i < leftBound.length; i++) {
            ans=Math.max(ans, heights[i]*(rtBound[i]-leftBound[i]+1));
        }
        return ans;
    }
}