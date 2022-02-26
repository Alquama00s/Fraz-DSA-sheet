import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        // Set<Integer> prefixSum_set;
        int ans = 0, temp;
        // making prefix sum array
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            temp = nums[i] - k;
            if (temp == 0)
                ans++;
            if (count.containsKey(temp))
                ans += count.get(temp);
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], 1);
            } else {
                count.put(nums[i], count.get(nums[i]) + 1);
            }
        }


        return ans;
    }

}