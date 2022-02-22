class Solution {
    public int removeDuplicates(int[] nums) {
        int sorted = 0, itr = 1, ans = 1;
        while (itr < nums.length) {
            if (nums[itr - 1] == nums[itr]) {
                itr++;
            } else {
                nums[++sorted] = nums[itr++];
                ans++;
            }
        }
        return ans;
    }
}