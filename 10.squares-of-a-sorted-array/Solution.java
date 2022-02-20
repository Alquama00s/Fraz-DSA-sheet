

class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, t1, t2;
        int[] ans = new int[nums.length];
        for (int k = ans.length - 1; k >= 0; k--) {
            t1 = (int) Math.pow(nums[i], 2);
            t2 = (int) Math.pow(nums[j], 2);

            if (t1 > t2) {
                ans[k] = t1;
                i++;
            } else {
                ans[k] = t2;
                j--;
            }
        }
        return ans;
    }
}