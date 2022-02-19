class Solution {
    public int pivotIndex(int[] nums) {
        int i = -1, j = nums.length;
        int rtSum = 0, ltSum = 0;
        int ans = -1;
        rtSum += nums[++i];
        ltSum += nums[--j];
        while (i <= j) {
            if (rtSum > ltSum) {
                ltSum += nums[--j];
            } else if (ltSum > rtSum) {
                rtSum += nums[++i];
            } else {
                if (i == j) {
                    ans = i;
                    break;
                }
                rtSum += nums[++i];
                ltSum += nums[--j];
            }
        }
        return ans;
    }
}