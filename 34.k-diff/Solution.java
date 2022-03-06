import java.util.*;

class Solution {
    public int findPairs(int[] nums, int k) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]-k)){
                ans+=1;
            }
            set.add(nums[i]);
        }
        return ans;
    }
}