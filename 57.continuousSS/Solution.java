import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum =0,mod;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            mod=sum%k;
            if (map.containsKey(mod) && (i - map.get(mod) > 1)) {
                return true;
            } else if(!map.containsKey(mod)){
                map.put(mod, i);
            }
        }
        return false;
    }
}
