class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().firstMissingPositive(new int[] { 1,2,0}));
    }

    public int firstMissingPositive(int[] nums) {
        
        int index;
        int firstNeg = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                temp = nums[i];
                nums[i] = nums[firstNeg];
                nums[firstNeg] = temp;
                firstNeg++;
            }
        }
        int ans = firstNeg+1;
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(firstNeg);
        for (int i = 0; i < firstNeg; i++) {
            index = Math.abs(nums[i]);
            if (index - 1 >= 0 && index - 1 < nums.length && nums[index - 1] > 0) {
                nums[index - 1] = -nums[index - 1];
            }
        }
        for (int i = 0; i < firstNeg; i++) {
            if (nums[i]>0) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
}