class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = 1;
                min = 1;
                ans = Math.max(ans, 0);
            } else {
                int tempMax=max;
                max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
                min = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * min));
                ans = Math.max(max, ans);
            }
        }
        return ans;
    }
}